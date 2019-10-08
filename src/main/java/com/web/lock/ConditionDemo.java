package com.web.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 96531
 * ReentrantLock+Condition??????? synchronized + wait+notify
 */
class TaskQueue {

    final Queue<String> queue = new LinkedList<>();

    final Lock lock = new ReentrantLock();
    //?????lock????????
    final Condition notEmpty = lock.newCondition();


    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (this.queue.isEmpty()) {
                //??????????
                notEmpty.await();
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }

    public void addTask(String name) {
        lock.lock();
        try {
            this.queue.add(name);
            //??????????????е???????
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

class WorkerThread extends Thread {
    //TaskQueue taskQueue;
    ArrayBlockingQueue<String> taskQueue;

    public WorkerThread(ArrayBlockingQueue<String> taskQueue) {
        this.taskQueue = taskQueue;
    }

    //public WorkerThread(ArrayBlockingQueue<String> taskQueue) {
    //	this.taskQueue = taskQueue;
    //}

    public void run() {
        while (!isInterrupted()) {
            String name;
            try {
                //name = taskQueue.getTask();
                name = taskQueue.take();
            } catch (InterruptedException e) {
                break;
            }
            String result = "Hello, " + name + "!";
            System.out.println(result);
        }
    }
}

public class ConditionDemo {

    public static void main(String[] args) throws Exception {
        //TaskQueue taskQueue = new TaskQueue();
        // ????????
        ArrayBlockingQueue<String> taskQueue = new ArrayBlockingQueue<>(10);
        WorkerThread worker = new WorkerThread(taskQueue);
        worker.start();
        // add task:
        //taskQueue.addTask("Bob");
        taskQueue.put("Bob");
        Thread.sleep(1000);
        //taskQueue.addTask("Alice");
        taskQueue.put("Alice");
        Thread.sleep(1000);
        //taskQueue.addTask("Tim");
        taskQueue.put("Tim");
        Thread.sleep(1000);
        worker.interrupt();
        worker.join();
        System.out.println("END");
    }
}
