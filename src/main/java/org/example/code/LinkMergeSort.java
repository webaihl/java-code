package org.example.code;

import org.example.commom.Node;

/** Liked Merge Sort
 * @author web
 * @date 2022年05月11日
 */
public class LinkMergeSort {

    public Node sortList(Node head) {
        // 1、递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        // 2、找到链表中间节点并断开链表 & 递归下探
        Node midNode = middleNode(head);
        Node rightHead = midNode.next;
        midNode.next = null;

        Node left = sortList(head);
        Node right = sortList(rightHead);

        // 3、当前层业务操作（合并有序链表）
        return mergeTwoLists(left, right);
    }

    //  找到链表中间节点（876. 链表的中间结点）
    private Node middleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并两个有序链表（21. 合并两个有序链表）
    private Node mergeTwoLists(Node l1, Node l2) {
        Node sentry = new Node(-1);
        Node curr = sentry;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        // 判断哪个先遍历完
        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }
}
