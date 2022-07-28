package org.example.designpatterns.strategy;

/**
 * @author web
 * @date 2022年06月19日
 */
@FunctionalInterface
public interface ValidationStrategy {
    boolean execute(String s);
}
