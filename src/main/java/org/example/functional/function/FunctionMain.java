package org.example.functional.function;

import java.util.Random;

public class FunctionMain {

    public static void main(String[] args) {
        Function<String,Integer> function = String::length;
        System.out.println(doFunction(String.valueOf(new Random().nextLong()),function));
    }

    public static Integer doFunction(String s, Function<String,Integer> function){
        return function.apply(s);
    }
}
