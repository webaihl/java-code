package com.web.designpattern.strategy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SubtractStrategy.java
 * @Description 算法2
 * @createTime 2020年08月08日 09:32:00
 */
public class SubtractStrategy implements Strategy {
    @Override
    public int doOperation(int n1, int n2) {
        return n1 - n2;
    }
}
