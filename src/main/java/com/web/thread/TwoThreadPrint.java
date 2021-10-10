package com.web.thread;

public class TwoThreadPrint {

    private volatile int start = 1;
    private final Object monitor = new Object();

    public void print(){
        synchronized (monitor){
            int limit = 1000000;
            while (start < limit){
                System.out.println(Thread.currentThread().getName()+": "+ start++);
                //先唤醒其他线程,未释放锁
                monitor.notifyAll();
                try {
                    //等待。释放持有的锁。没有if会导致有个线程会一直等待
                    if (start < limit){
                        monitor.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        TwoThreadPrint print = new TwoThreadPrint();
        Thread t1 = new Thread(print::print, "ji");
        Thread t2 = new Thread(print::print, "ou");
        t1.start();
        t2.start();

    }
}
