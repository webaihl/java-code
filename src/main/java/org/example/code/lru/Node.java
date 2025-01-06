package org.example.code.lru;

import lombok.Data;

/**
 * 节点node,存放key、val值、前节点、后节点
 */

public class Node {
    public Node next;
    public Node prev;
    public Integer key;
    public Integer val;

    public Node() {}

    public Node(Integer key, Integer val) {
        this.key = key;
        this.val = val;
    }
}
