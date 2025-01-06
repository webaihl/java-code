package org.example.code.lru;

public class Main {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.get(1);
        cache.get(3);
        cache.put(4,4);
        System.out.println(cache);
    }
}
