package org.example.juc.pool;

import org.example.commom.SleepUtil;
import org.junit.Test;

import java.util.concurrent.*;

public class ScheduleDemoTest {


    @Test
    public void t1() {
        long start = System.currentTimeMillis();
        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> futureHandle = scheduled.scheduleWithFixedDelay(() -> {
            t2();
            System.out.println("执行成功");
            scheduled.shutdown();
        }, 5L, 10L, TimeUnit.SECONDS);

        new Thread(() -> {
            try {
                futureHandle.get(10L, TimeUnit.SECONDS);
                System.out.println("结束");
            } catch (Exception e) {
                //futureHandle.cancel(false);
                if (e instanceof CancellationException){
                    System.out.println("报错了已正常处理: "+e.getMessage());
                }else {
                    System.out.println("报错了无法处理: "+e.getMessage());
                }
            } finally {
                scheduled.shutdown();
                System.out.println("子线程结束: " + (System.currentTimeMillis() - start));
            }
        }).start();

        SleepUtil.delay(15L);
        System.out.println("主线程结束: " + (System.currentTimeMillis() - start));
    }

    public void t2() {
        System.out.println("1111111111");
        SleepUtil.delay(11L);
        System.out.println("2222222222");
    }

}