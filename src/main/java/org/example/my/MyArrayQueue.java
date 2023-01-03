package org.example.my;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyArrayQueue.java
 * @Description
 * @createTime 2022年11月22日 13:12:00
 */
public class MyArrayQueue<T> {

    public Object[] items;
    // 队列满时的阻塞锁
    private final Object full = new Object();
    //队列空时的阻塞锁
    private final Object empty = new Object();

    private int getIndex = 0;
    private int putIndex = 0;

    //记录队列中的元素
    public int count = 0;
    public MyArrayQueue(int size){
        items = new Object[size];
    }

    /**
     * 队头出列
     * @return item
     */
    public T get(){
        synchronized (empty){ //判断是否为空
            while (count == 0){
                try {
                    empty.wait(); //put方法会唤醒它
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        synchronized (full){
            count--;
            Object t = items[getIndex];
            items[getIndex] = null;

            getIndex++;
            if (getIndex == items.length){
                getIndex = 0;
            }

            //空出了一个位置，可以写了
            full.notify();
            return (T)t;
        }
    }

    /**
     * 队尾写入
     * @param t 元素
     */
    public void put(T t){

        synchronized (full){
            while (count == items.length){ // 防止虚假唤醒
                try {
                    full.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        synchronized (empty){//必须保证有空间才能写
            count++;
            items[putIndex] = t;

            putIndex++;
            if (putIndex == items.length){
                putIndex = 0;
            }
            //唤醒其他写线程，有了一个元素，不空了，可以读了
            empty.notify();
        }
    }

}
