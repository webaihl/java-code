package org.example.complefuture;

import java.util.concurrent.TimeUnit;

public class SleepUtil {

    public static void delay(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String apply(long timeout,String s) {
        delay(timeout);
        return "加工："+s;
    }

    public static String product(long timeout,String s) {
        delay(timeout);
        return s;
    }

    public static void accept(long timeout, String s) {
        delay(timeout);
        System.out.println("消费：" + s);
    }
}
