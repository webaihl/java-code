package org.example.commom;

import lombok.Data;

/**
 * @author web
 * @date 2022年05月11日
 */

@Data
public class Node {

    public Integer val;
    public Node next;

    public Node(Integer val) {
        this.val = val;
        this.next = null;
    }
}
