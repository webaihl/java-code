package com.web.designpattern.strategy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Main.java
 * @Description 1、使用策略模式可以避免使用多重条件转移语句。
 * spring中可以BeanID作为key，具体策略作为value。https://www.javazhiyin.com/42126.html
 * @createTime 2020年08月08日 09:37:00
 */
public class Main {

    public static void main(String[] args) {
        StrategyContext context = new StrategyContext();
        context.setStrategy(new AddStrategy());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context.setStrategy(new SubtractStrategy());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
    }
}
