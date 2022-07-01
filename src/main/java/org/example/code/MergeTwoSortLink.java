package org.example.code;

import org.example.code.helper.ListNode;
import org.example.code.helper.Utils;

import static org.example.code.helper.Utils.list2Linked;

public class MergeTwoSortLink {
    public static void main(String[] args) {
        ListNode l1 = list2Linked(new Integer[]{1, 2, 3});
        ListNode l2 = list2Linked(new Integer[]{1, 2, 3});


        ListNode res = mergeTwoLists2(l1, l2);
        Utils.printLinked(res);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
             l2.next = mergeTwoLists(l1, l2.next);
             return l2;
        }
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(null);
        ListNode cur = sentry;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        cur.next = l1 == null? l2:l1;
        return sentry.next;
    }


}
