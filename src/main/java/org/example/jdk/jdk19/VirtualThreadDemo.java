package org.example.jdk.jdk19;

import cn.hutool.core.util.ReUtil;
import org.checkerframework.checker.regex.RegexUtil;
import org.example.commom.SleepUtil;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.stream.IntStream;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName VirtualThreadDemo.java
 * @Description 虚拟线程
 * @createTime 2022年10月09日 18:53:00
 */
public class VirtualThreadDemo {
    public static void main(String[] args) throws InterruptedException {
//        newCollectionCase();
//        baseUse();
//        v2p();
//        continuationsDemo();
        virtualThreadPerformance();
    }

    private static void newCollectionCase() {
        List<Integer> s = List.of(1, 23);
        s.remove(1);
        Set.of(2, 3, 3);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(null, null);

        Map<Integer, Integer> integerIntegerMap = Map.of(1, 1, 2, 2);
        integerIntegerMap.put(1, 1);
    }

    private static void baseUse() throws InterruptedException {
        var pthrad = Thread.ofPlatform().unstarted(() -> {
            System.out.println(Thread.currentThread());
        });

        pthrad.start();
        pthrad.join();

        var vthrad = Thread.ofVirtual().unstarted(() -> {
            System.out.println(Thread.currentThread());
        });

        vthrad.start();
        vthrad.join();
//        System.out.println("class = "+vthrad.getClass());

        var task = ForkJoinPool.commonPool()
                .submit(() -> System.out.println(Thread.currentThread()));
        task.join();
    }

    /**
     * 阻塞时可能会切换平台线程
     *
     * @throws InterruptedException
     */
    public static void v2p() throws InterruptedException {
        List<Thread> threads = IntStream.rangeClosed(0, 1000).mapToObj(index ->
                Thread.ofVirtual().unstarted(() -> {
                    if (index == 10) {
                        System.out.println(Thread.currentThread());
                        //VirtualThread[#32]/runnable@ForkJoinPool-1-worker-1
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (index == 10) {
                        System.out.println(Thread.currentThread());
                        //VirtualThread[#32]/runnable@ForkJoinPool-1-worker-3
                    }
                })
        ).toList();

        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }

    }

//    public static void continuationsDemo() {
//
//        ContinuationScope scope = new ContinuationScope("scope");
//        Continuation continuation = new Continuation(scope, () -> {
//            System.out.println("running");
//            Continuation.yield(scope);
//            System.out.println("still running");
//        });
//
//        System.out.println("start");
//        continuation.run();
//        System.out.println("start again");//like the yield of python
//        continuation.run();
//        System.out.println("done");
//    }

    public static void virtualThreadPerformance() throws InterruptedException {
        Set<String> poolNames = ConcurrentHashMap.newKeySet();
        Set<String> pThreadNames = ConcurrentHashMap.newKeySet();

        var threads = IntStream.range(0, 10_000_000).mapToObj(i ->
                Thread.ofVirtual().unstarted(() -> {
                    poolNames.add(getPoolNameAndTName(1));
                    pThreadNames.add(getPoolNameAndTName(2));
                })
        ).toList();

        Instant begin = Instant.now();
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }

        Instant end = Instant.now();
        System.out.println("time: " + Duration.between(begin, end).toMillis());
        System.out.println("core: " + Runtime.getRuntime().availableProcessors());
        System.out.println("pools: " + poolNames.size());
        System.out.println("plateform threads: " + pThreadNames.size());
    }

    public static String getPoolNameAndTName(int index) {
        //VirtualThread[#280]/runnable@ForkJoinPool-1-worker-3
        String split = Thread.currentThread().toString().split("@")[1];
        return ReUtil.get("ForkJoinPool-(\\d+)-worker-(\\d+)", split, index);
    }


}
