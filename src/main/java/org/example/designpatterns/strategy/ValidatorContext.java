package org.example.designpatterns.strategy;

/**
 * @author web
 * @date 2022年06月19日
 */
public class ValidatorContext {

    private final ValidationStrategy strategy;

    public ValidatorContext(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s){
        return strategy.execute(s);
    }

}
