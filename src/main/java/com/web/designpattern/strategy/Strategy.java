package com.web.designpattern.strategy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Strategy.java
 * @Description 策略接口。
 * @createTime 2020年08月08日 09:29:00
 */
public interface Strategy {
    //定义需要实现的算法
    int doOperation(int n1, int n2);
}
