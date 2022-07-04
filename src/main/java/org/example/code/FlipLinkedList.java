package org.example.code;

import org.example.code.helper.ListNode;
import org.example.code.helper.Utils;

import static org.example.code.helper.Utils.list2Linked;

public class FlipLinkedList {

    public static void main(String[] args) {
        ListNode l1 = list2Linked(new Integer[]{1, 2, 3, 4});
        ListNode l2 = list2Linked(new Integer[]{1});
        ListNode s = flip3(l1);
        Utils.printLinked(s);
    }

    /**
     * 三指针
     */
    public static ListNode flip1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = null, cur = head, q;
        while (cur != null) {
            q = cur.next;
            cur.next = p;
            p = cur;
            cur = q;
        }

        return p;
    }

    public static ListNode flip2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, prev = null;
        while (cur != null) {
           ListNode next = cur.next;
           cur.next = prev;
           prev = cur;
           cur = next;
        }
        return prev;
    }

    public static ListNode flip3(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = flip3(head);
        //todo ??
        return newHead;
    }
}
