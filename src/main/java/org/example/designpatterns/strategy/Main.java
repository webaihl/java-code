package org.example.designpatterns.strategy;

import javax.xml.validation.Validator;

/**
 * @author web
 * @date 2022年06月19日
 */
public class Main {

    public static void main(String[] args) {

        ValidatorContext numericValidator =
                new ValidatorContext((String s) -> s.matches("[a-z]+"));
        boolean b1 = numericValidator.validate("aaaa");
        System.out.println(b1);

        ValidatorContext lowerCaseValidator =
                new ValidatorContext((String s) -> s.matches("\\d+"));
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println(b2);
    }
}
