package org.example.juc.cpu;

import org.springframework.util.StopWatch;

public class FalseSharingCache {

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch("@看点代码再上班");
        stopWatch.start();
        System.out.println("====== start to iterate ======");
        autoIncrement(new LongNumber());

        stopWatch.stop();
        System.out.println("cost " + stopWatch.getTotalTimeMillis() + "ms");
    }

    private static void autoIncrement(LongNumber longNumber) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                longNumber.n1++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                longNumber.n2++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //ClassLayout.parseInstance(longNumber).toPrintable();
    }

    static class LongNumber {
        //@sun.misc.Contended 缓存行长度为64字节
        volatile long n1;
        volatile long n2;
    }
}
