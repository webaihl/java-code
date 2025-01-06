package org.example.jdk.jdk8.file;

public class IPCount {

    String ip;
    long count;

    public IPCount(String ip, long count) {
        this.ip = ip;
        this.count = count;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
