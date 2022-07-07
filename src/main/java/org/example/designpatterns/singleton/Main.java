package org.example.designpatterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Main.java
 * @Description
 * @createTime 2022年07月07日 20:06:00
 */
public class Main {

    public static void main(String[] args) {
        //User userInstance1 = SingletonDemo.getUserInstance();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.rangeClosed(1, 10_000).parallel().forEach(e -> executorService.execute(
        () -> {
            System.out.println(SingletonDemo.getUserInstance());
        }));
    }
}
