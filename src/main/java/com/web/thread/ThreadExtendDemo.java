package com.web.thread;

public class ThreadExtendDemo extends Thread {

    @Override
    public void run() {
        System.out.println("hah");
    }

    public static void main(String[] args) {

        new ThreadExtendDemo().start();
    }

}
