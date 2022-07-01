package org.example.code;

import org.example.code.helper.ListNode;

import static org.example.code.helper.Utils.list2Linked;
import static org.example.code.helper.Utils.printLinked;

/**
 * @author web
 * @date 2022年07月01日
 */
public class LikedMiddleNode {

    public static void main(String[] args) {
        ListNode l1 = list2Linked(new Integer[]{1, 2, 3, 4});
        printLinked(middleNode(l1));
        ListNode l2 = list2Linked(new Integer[]{1, 2, 3});
        printLinked(middleNode(l2));
    }

    private static  ListNode middleNode(ListNode h){
        ListNode low = h;
        ListNode fast = h;
        while (fast!= null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }

}
