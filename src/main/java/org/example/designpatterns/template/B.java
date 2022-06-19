package org.example.designpatterns.template;

/**
 * @author web
 * @date 2022年06月19日
 */
public class B extends OnlineBanking{
    @Override
    void makeCustomerHappy(int c) {
        System.out.println("Function B Handle: "+ c);
    }
}