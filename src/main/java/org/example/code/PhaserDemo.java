package org.example.code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * 41 分
 * 既正确且硬币的个数又最少
 */
public class PhaserDemo {

    public static final int ONEFEN  =  1;
    public static final int FIVEFEN  =  5;
    public static final int TENFEN  =  10;
    public static final int TWENTYFINEFEN  = 25;

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(3);
        Runnable r = () -> {
            System.out.println("phase-0");
            phaser.arriveAndAwaitAdvance();
            System.out.println("phase-1");
            phaser.arriveAndAwaitAdvance();
            System.out.println("phase-2");
            phaser.arriveAndDeregister();
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.submit(r);
        }
        executor.shutdown();
    }

}
