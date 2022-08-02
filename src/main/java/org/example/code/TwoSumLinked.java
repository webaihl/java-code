package org.example.code;

import org.example.code.helper.ListNode;
import org.example.code.helper.Utils;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author web
 * @date 2022年08月02日
 * 2个逆序、前导不为0、非空、链表之和
 */

public class TwoSumLinked {

    public static void main(String[] args) {
//        Utils.printLinked(sum(Utils.list2Linked(new Integer[]{9,9,9,9,9,9,9}),
//                Utils.list2Linked(new Integer[]{9,9,9,9})));
//
        Utils.printLinked(sum(Utils.list2Linked(new Integer[]{2,4,9}),
                Utils.list2Linked(new Integer[]{5,6,4,9})));
    }

    public static ListNode sum(@Nonnull ListNode l1, @Nonnull ListNode l2) {

        ListNode h1 = l1;
        ListNode h2 = l2;
        int remainder = 0, sum;
        while (h1 != null && h2 != null) {
            sum = h1.val + h2.val + remainder;
            if (sum > 9) {
                remainder = 1;
                sum -= 10;
            }
            h1.val = h2.val = sum;
            h1 = h1.next;
            h2 = h2.next;
        }


        if(h1 == null){
            h1 = h2;
            l1 = l2;
        }

        while (h1 != null) {
            sum = h1.val + remainder;
            if (sum > 9) {
                remainder = 1;
                sum -= 10;
            }
            h1.val = sum;

            if (h1.next == null && remainder > 0){
                h1.next = new ListNode(remainder);
                remainder = 0;
            }

            h1 = h1.next;

        }

        return l1;
    }
}
