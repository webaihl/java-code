package org.example.juc.pool;

import org.example.commom.SleepUtil;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ScheduleDemo {

    public static void main(String[] args) {
//        fixedRate();
        fixFixedDelay();
    }

    // 当前任务执行时间大于等于间隔时间，任务执行后立即执行下一次任务。相当于连续执行了。
    public static void fixedRate(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Date startTime = new Date();
        System.out.println("startTime: " + startTime);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("beginTime: " + new Date());
            SleepUtil.delay(5);
            System.out.println("endTime: " + new Date());
        }, 2, 3, TimeUnit.SECONDS);
    }

    //每当上次任务执行完毕后，必定间隔一段时间执行。不管前一个任务执行时间大于、等于还是小于间隔时间，当前任务执行效果都是一样的。
    public static void fixFixedDelay(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Date startTime = new Date();
        System.out.println("startTime: " + startTime);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("beginTime: " + new Date());
            SleepUtil.delay(5);
            System.out.println("endTime: " + new Date());
        }, 2, 3, TimeUnit.SECONDS);
    }
}
