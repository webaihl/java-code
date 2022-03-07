package org.example.functional.function;

import java.util.Random;

public class BitFunctionMain {

    public static void main(String[] args) {
        BitFunction<String,Integer,Double> bitFunction = (s,i)  -> Double.parseDouble(s) / i;
        System.out.println(doBitFunction(String.valueOf(new Random().nextDouble()),
                new Random().nextInt(100), bitFunction));
    }


    public static Double doBitFunction(String s ,Integer i,BitFunction<String,Integer,Double> bitFunction){
        return bitFunction.apply(s,i);
    }
}
