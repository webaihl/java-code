package com.web.random;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

//SecureRandom 在linux上耗尽随机池时，阻塞
public class SecureRandomDemo {

    private static Random random;

    static {
        //random = SecureRandom.getInstanceStrong();
        random = new  SecureRandom();
    }

    public static int getRandom(){
        return random.nextInt(1000);
    }

    public static void main(String[] args) {
        ExecutorService executors =  Executors.newFixedThreadPool(10);
        AtomicInteger finalI = new AtomicInteger();
        for (int i =0;i<1000_000_000;i++){
            executors.submit(()->{
                getRandom();
                System.out.println(finalI.getAndIncrement());
            });
        }
        executors.shutdown();
    }
}
