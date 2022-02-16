package org.example.juc.bashthread.pool;

import org.example.commom.SleepUtil;

import java.util.concurrent.*;

public class RecycleIdleThread {

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
                2,2, TimeUnit.SECONDS,workQueue);

        for(int i = 0;i<4;i++){
            executor.execute(()-> System.out.println(Thread.currentThread().getName()));
        }

        for(int i = 0;i<4;i++){
            SleepUtil.delay(1);
            System.out.println("当前线程池大小："+executor.getPoolSize());
        }
    }
}
