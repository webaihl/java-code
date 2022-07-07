package org.example.designpatterns.singleton;

import org.example.commom.User;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SingletonDemo.java
 * @Description 1、线程池、数据库连接池；2、系统属性获取 properties工具
 * @createTime 2022年07月07日 19:50:00
 */

public class SingletonDemo {

    //私有化构造器
    private SingletonDemo(){}

    //定义属性实例
    //volatile保证内存可见性，防止出现不完整的对象
    private static volatile User instance;

    //1、不加锁 出现线程问题
    //2、public synchronized User getUserInstance() 等于是类锁性能问题
    public static User getUserInstance(){
        if (instance != null){
            //1、多个线程通过第一个if,在这里阻塞
            //2、经过sync后，再进行一次null判断，保证不会重复实例化
            synchronized (SingletonDemo.class){
              //  if (instance != null){
                    instance = new User();
               // }
            }
        }
        return instance;
    }
}
