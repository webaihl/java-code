package org.example.functional.comsumer;

public class ConsumerMain {
    public static void main(String[] args) {
        Consumer consumer = () -> System.out.println("这是一个consumer");
        doConsumer(consumer);
    }

    public static void doConsumer(Consumer consumer){
        consumer.accept();
    }
}
