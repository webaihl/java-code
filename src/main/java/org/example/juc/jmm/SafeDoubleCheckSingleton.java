package org.example.juc.jmm;

/**
 * @auther zzyy
 * @create 2021-03-17 15:00
 */

public class SafeDoubleCheckSingleton
{
    private volatile static SafeDoubleCheckSingleton singleton = null;

    //私有化构造方法
    private SafeDoubleCheckSingleton(){ }

    //双重锁设计
    public static SafeDoubleCheckSingleton getInstance(){
        if (singleton == null){
            //1.多线程并发创建对象时，会通过加锁保证只有一个线程能创建对象
            synchronized (SafeDoubleCheckSingleton.class){
                //由于sync外面可能阻塞多个线程，不加判断的话，进入了第一个if的线程获取锁之后会直接new
                if (singleton == null){
                    // 1开辟内存、2初始化内存、3将引用执行内存地址
                    // 线程A可能执行13之后，线程B在第一个if从主内存读取到的!=null直接返回未初始化完成的对象
                    //隐患：多线程环境下，由于重排序，该对象可能还未完成初始化就被其他线程读取
                    singleton = new SafeDoubleCheckSingleton();
                }
            }
        }
        //2.对象创建完毕，执行getInstance()将不需要获取锁，直接返回创建对象
        return singleton;
    }

    public static void main(String[] args)
    {
        SafeDoubleCheckSingleton instance = SafeDoubleCheckSingleton.getInstance();
        System.out.println(instance);
    }
}
