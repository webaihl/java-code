package org.example.code;

import org.example.code.helper.ListNode;
import org.example.code.helper.Utils;

public class FlipLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;

        Utils.printLinked(l1);
        System.out.println();
        ListNode s = flip1(l1);
        Utils.printLinked(s);
    }

    //todo ?
    public static ListNode flip1(ListNode head){
        if (head == null){return null;}
        ListNode p = null, cur = head ,q;
        while (cur != null){
            q = cur.next;
            cur.next = p;
            p = cur;
            cur = q;
        }

        return p;
    }
}
