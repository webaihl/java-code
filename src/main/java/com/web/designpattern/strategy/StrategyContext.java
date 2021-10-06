package com.web.designpattern.strategy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName StrategyContext.java
 * @Description context 控制执行的算法。
 * @createTime 2020年08月08日 09:33:00
 */
public class StrategyContext {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int n1, int n2) {
        return this.strategy.doOperation(n1, n2);
    }
}
