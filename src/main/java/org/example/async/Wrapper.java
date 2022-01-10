package org.example.async;

public class Wrapper {

    private Object param;
    private Listener listener;
    private Worker worker;

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void addListener(Listener listener) {
        this.listener = listener;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void addWorker(Worker worker) {
        this.worker = worker;
    }
}
