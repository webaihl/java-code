package org.example.designpatterns.template;

/**
 * @author web
 * @date 2022年06月19日
 */
public class Main {

    public static void main(String[] args) {
        A a = new A();
        a.processCustomer(1);

        B b = new B();
        b.processCustomer(1);
    }
}
