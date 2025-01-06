package org.example.jvm.refrence;

import org.example.commom.SleepUtil;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RefCounter.java
 * @Description
 * @createTime 2022年09月09日 14:44:00
 */
public class RefCounter {

    public Object instance = null;

    private static final int MB = 1024*1024;

    public static void main(String[] args) {
        RefCounter a = new RefCounter();
        RefCounter b = new RefCounter();
        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        System.gc();

        SleepUtil.delay(10);
    }
}
