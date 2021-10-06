package com.web.designpattern.strategy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AddStrategy.java
 * @Description 算法1
 * @createTime 2020年08月08日 09:30:00
 */
public class AddStrategy implements Strategy {
    @Override
    public int doOperation(int n1, int n2) {
        return n1 + n2;
    }
}
