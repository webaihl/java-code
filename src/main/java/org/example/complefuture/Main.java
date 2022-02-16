package org.example.complefuture;

import org.example.commom.SleepUtil;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        List<String> myList = List.of("web","alice","bob");
        StopWatch stopWatch = new StopWatch("parallelStream");
        stopWatch.start("parallelStream");
        List<String> collect = myList.parallelStream()
                .map(e -> SleepUtil.apply(1, e))
                .collect(Collectors.toList());
        System.out.println(collect);
        stopWatch.stop();
        stopWatch.start("CompletableFuture");
        Stream<CompletableFuture<String>> collectCom =
                myList.stream()
                        .map(e -> CompletableFuture.supplyAsync(() -> SleepUtil.apply(1, e),es));
//        CompletableFuture[] collectCom  = collectCom.toArray(CompletableFuture[]::new);
//        CompletableFuture.allOf(collectCom).join();
        List<Object> res = collectCom.map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(res);
        stopWatch.stop();
        stopWatch.start("A&B-->C");
        System.out.println(CompletableFuture.supplyAsync(() -> SleepUtil.product(3L, "A"))
                .thenCombine(
                        CompletableFuture.supplyAsync(
                                () -> SleepUtil.product(2L, "B")),
                                (a, b) -> SleepUtil.apply(1L, a + b)
                ).get());
        stopWatch.stop();
        stopWatch.start("A|B-->C");
        System.out.println(CompletableFuture.supplyAsync(() -> SleepUtil.product(1L, "A"))
                .applyToEitherAsync(
                        CompletableFuture.supplyAsync(
                                () -> SleepUtil.product(1L, "B")),
                        s -> SleepUtil.apply(1L, s)
                ).get());
        stopWatch.stop();
        stopWatch.start("A&B&C");
        System.out.println(CompletableFuture.supplyAsync(() -> SleepUtil.apply(1L, "A"))
                .thenApplyAsync(s -> SleepUtil.apply(1L, s))
                .thenApplyAsync(e -> SleepUtil.apply(1L, e)).get());
        stopWatch.stop();
        stopWatch.start("A|B|C(anyOf)");// todo not anyOf
        System.out.println(CompletableFuture.runAsync(() -> SleepUtil.apply(1L, "A"))
                .thenRunAsync(() -> SleepUtil.apply(2L, "B"))
                .thenRunAsync(() -> SleepUtil.apply(3L, "C")).get());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        es.shutdown();
    }


}
