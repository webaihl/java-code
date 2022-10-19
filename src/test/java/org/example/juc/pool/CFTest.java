package org.example.juc.pool;

import lombok.extern.slf4j.Slf4j;
import org.example.code.helper.Utils;
import org.example.commom.SleepUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author web
 * @date 2022年09月01日
 */
public class CFTest {

    ExecutorService executors;

    static Random random = new Random();

    @Before
    public void setUp(){
        executors = Executors.newFixedThreadPool(6);
    }

    @After
    public void after(){

        try {
            executors.shutdown();
            while (!executors.awaitTermination(15, TimeUnit.SECONDS)){}
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void TestAllOf(){
        long startTime = Instant.now().getEpochSecond();
        StringBuffer buffer = new StringBuffer();
        List<String> messages = Arrays.asList("a", "b", "c", "d");
        List<CompletableFuture<Boolean>> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg)
                        .thenApplyAsync(CFTest::delayedUpperCase)
                        .thenApplyAsync(CFTest::print)).toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        CompletableFuture<String> exceptionHandler = allOf.handle((v,e)->{
          if (e != null){
              buffer.append(e.getCause().getMessage());
          }
            return "";
        });

        try {
            System.out.println(allOf.join());
        } catch (CompletionException ex) { // just for testing
//            System.out.println("completed exceptionally"+ ex.getCause().getMessage());
        }
//
        exceptionHandler.join();
        System.out.println(buffer);
        long endTime = Instant.now().getEpochSecond() - startTime;
        System.out.println(endTime);
    }

    //error 不累计
    // 计算正常的
    private static String delayedUpperCase(String s) {
        SleepUtil.delay(2);
        if (Objects.equals(s,"b")){
            throw new RuntimeException(String.format("%s not valid character",s));
        }
        return s.toUpperCase();
    }


    private static Boolean print(String s) {
        SleepUtil.delay(2);
        System.out.println(s);
        return true;
    }

    private static void randomSleep() {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            // ...
        }
    }

}
