package org.example.designpatterns.template;

/**
 * @author web
 * @date 2022年06月19日
 */
public abstract class OnlineBanking {

    public void processCustomer(int id){
//        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(id);
    }

    abstract void makeCustomerHappy(int c);
}
