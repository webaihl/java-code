package org.example.juc.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.example.commom.SleepUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的异常处理
 *  @link  http://kriszhang.com/uncaught-exception/
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        /** 对线程抛出的异常统一处理 这里只记一个错误日志 */
        Thread.UncaughtExceptionHandler UEH = (t, e) -> e.printStackTrace();
        /** 创建一个线程池 */
        ThreadPoolExecutor pool =
                new ThreadPoolExecutor(10,80,30, TimeUnit.MINUTES,
                        new LinkedBlockingQueue<>(30),
                        new ThreadFactoryBuilder()
                                .setNameFormat("...")
                                .setDaemon(false)
                                .setUncaughtExceptionHandler(UEH)
                                .build(),
                        new ThreadPoolExecutor.CallerRunsPolicy());

        // pool.execute(ExceptionDemo::testCalc); 会先执行afterExecute，通过setUncaughtExceptionHandler捕获异常，重新抛出
        //pool.submit(ExceptionDemo::testCalc); 会直接吞掉异常
        //CompletableFuture.runAsync(ExceptionDemo::testCalc,pool); //会直接吞掉异常
        //exceptionally 会抛出两个异常
        CompletableFuture.runAsync(ExceptionDemo::testCalc,pool).exceptionally(e->{
            e.printStackTrace();
            return null;
        });
        SleepUtil.delay(3);
        pool.shutdown();
    }

    public static void testCalc(){
        int a = 100 / 0;
    }
}
