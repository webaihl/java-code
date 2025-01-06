package org.example.functional.supplier;

import java.util.Random;

public class ProductMain {

    public static void main(String[] args) {
        Product<Integer> product = () -> new Random().nextInt(1000);
        System.out.println(doProduct(product));
    }

    public static Integer doProduct(Product<Integer> product){
        return product.get();
    }
}
