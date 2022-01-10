package org.example.async;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BootStrap {


    public static void main(String[] args) {
        BootStrap bootStrap = new BootStrap();
        Worker worker = bootStrap.newWork();

        Wrapper wrapper = new Wrapper();
        wrapper.addWorker(worker);
        wrapper.setParam("hello");

        bootStrap.doWork(wrapper).addListener((result)->{
            System.out.println(Thread.currentThread().getName()+"---"+new Date());
            System.out.println("res-------------->"+result);
        });

        System.out.println(Thread.currentThread().getName()+"---"+new Date());
    }

    private Wrapper doWork(Wrapper wrapper) {
        new Thread(()->{
            Worker worker = wrapper.getWorker();
            String result = worker.action(wrapper.getParam());
            wrapper.getListener().result(result);
        }).start();

        return wrapper;
    }


    private Worker newWork() {
        return (obj)->{
            try {
                TimeUnit.SECONDS.sleep(5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return obj + " World!";
        };
    }
}
