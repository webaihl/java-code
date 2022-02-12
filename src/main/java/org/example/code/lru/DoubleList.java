package org.example.code.lru;

/**
 * 双向链表，属性有size、头节点、尾节点。
 * 提供api：
 * addFirst(): 头插法入链表
 * remove(): 删除最后一个节点
 * remove(Node node):删除特定节点
 * size()：获取链表长度
 */
public class DoubleList {

    private int size;
    private final Node head;
    private final Node tail;

    public DoubleList() {
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addFirst(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public Node removeLast(){
        if (size == 0) {
            return null;
        }
        Node temp = tail.prev;
        tail.prev = temp.prev;
        temp.prev.next = tail; //temp.next;
        temp.next = null;
        temp.prev = null;
        size--;
        return temp;
    }

    public void remove(Node node){
        if (node == null || node.prev == null || node.next== null){return;}
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next=null;
        size--;
    }

    public int size(){
        return size;
    }
}
