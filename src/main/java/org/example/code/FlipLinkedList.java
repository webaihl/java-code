package org.example.code;

import org.example.code.helper.ListNode;
import org.example.code.helper.Utils;

import static org.example.code.helper.Utils.list2Linked;

public class FlipLinkedList {

    public static void main(String[] args) {
        ListNode l1 = list2Linked(new Integer[]{1, 2, 3, 4});

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
