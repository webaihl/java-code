package org.example.code.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * https://segmentfault.com/a/1190000039256321
 * hashmap+双向链表。
 * 1.利用HashMap的get、put方法O(1)的时间复杂度，快速取、存数据。
 * 2.利用doubleLinkedList的特征（可以访问到某个节点之前和之后的节点），实现O(1)的新增和删除数据。
 * api:
 * get(int key): 为null返回-1
 * put(int key, int value)
 * 若map中有，删除原节点，增加新节点
 * 若map中没有，map和链表中新增新数据。
 */
public class LRUCache {
    private final Map<Integer, Node> map;
    private final int cap;
    private final DoubleList cache;

    public LRUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>(cap);
        cache = new DoubleList();
    }

    public int get(int key) {
        Node s = map.get(key);
        if (s != null){
            put(s.key,s.val);
            return s.val;
        }
        return -1;
    }

    public void put(int key, int val) {
        Node node = new Node(key, val);
        //相同的key直接覆盖
        if (map.get(key) != null) {
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key, node);
            return;
        }
        if (this.cap == cache.size()) {
            Node s = cache.removeLast();
            map.remove(s.key);
        }
        map.put(key, node);
        cache.addFirst(node);
    }
}
