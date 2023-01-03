package org.example.my;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyArrayQueueTest.java
 * @Description
 * @createTime 2022年11月22日 14:39:00
 */
class MyArrayQueueTest {

    @Test
    void get() {
        MyArrayQueue<Integer> myArrayQueue = new MyArrayQueue<>(3);
        System.out.println(myArrayQueue.get());
    }

    @Test
    void put() {
        MyArrayQueue<Integer> myArrayQueue = new MyArrayQueue<>(3);
        myArrayQueue.put(1);
        myArrayQueue.put(2);
        myArrayQueue.put(3);
        myArrayQueue.get();
        myArrayQueue.put(4);
        assertEquals(3, myArrayQueue.count);
        while (myArrayQueue.count > 0){
            System.out.print(myArrayQueue.get());
        }
    }

    @Test
    void multiThreadOperation() throws InterruptedException {
        final MyArrayQueue<Integer> queue = new MyArrayQueue<>(299);
        Thread t1 =  new Thread(() -> IntStream.rangeClosed(1,100).boxed().forEach(queue::put));
        Thread t2 =  new Thread(() -> IntStream.rangeClosed(1,100).boxed().forEach(queue::put));
        Thread t3 =  new Thread(() -> IntStream.rangeClosed(1,100).boxed().forEach(queue::put));
        Thread t4 =  new Thread(queue::get);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println(queue.count);
    }
}