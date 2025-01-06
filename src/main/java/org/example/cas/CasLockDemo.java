package org.example.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class CasLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void lock(){
        System.out.println(Thread.currentThread().getName()+ " Come in ");
        while (!atomicReference.compareAndSet(null,Thread.currentThread())){}
        System.out.println(Thread.currentThread().getName()+ " Locked");
    }

    public void unlock(){
        atomicReference.compareAndSet(Thread.currentThread(),null);
        System.out.println(Thread.currentThread().getName()+ " Release");
    }

    public static void main(String[] args) {
        CasLockDemo lockDemo = new CasLockDemo();
        new Thread(()->{
            lockDemo.lock();
            try {  TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) {  e.printStackTrace(); }
            lockDemo.unlock();
        },"t1").start();

        new Thread(()->{
            lockDemo.lock();
            lockDemo.unlock();
        },"t2").start();
    }
}
