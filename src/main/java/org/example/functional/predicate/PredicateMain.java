package org.example.functional.predicate;

import java.util.Random;

public class PredicateMain {

    public static void main(String[] args) {

        Predicate p = () -> new Random().nextInt(1000) > 500;
        System.out.println(doPredicate(p));
    }

    public static boolean doPredicate(Predicate p){
        return p.test();
    }
}
