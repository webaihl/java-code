package org.example.code;

import org.example.code.helper.ListNode;
import org.example.code.helper.Utils;

import javax.annotation.Nonnull;

/**
 * @author web
 * @date 2022年08月02日
 * 2个逆序、前导不为0、非空、链表之和
 */

public class TwoSumLinked {

    public static void main(String[] args) {
        Utils.printLinked(sum(Utils.list2Linked(new Integer[]{0}),
                Utils.list2Linked(new Integer[]{7,3})));

        Utils.printLinked(sum(Utils.list2Linked(new Integer[]{9,9,9,9,9,9,9}),
                Utils.list2Linked(new Integer[]{9,9,9,9})));
        Utils.printLinked(sum(Utils.list2Linked(new Integer[]{2,4,9}),
                Utils.list2Linked(new Integer[]{5,6,4,9}))); //70401

        Utils.printLinked(sum(Utils.list2Linked(new Integer[]{8,3,2}),
                Utils.list2Linked(new Integer[]{9,2,1})));

        Utils.printLinked(sum(Utils.list2Linked(new Integer[]{5}),
                Utils.list2Linked(new Integer[]{5})));

        Utils.printLinked(sum(Utils.list2Linked(new Integer[]{3,7}),
                Utils.list2Linked(new Integer[]{9,2})));
    }

    public static ListNode sum(@Nonnull ListNode l1, @Nonnull ListNode l2) {

        ListNode h1 = l1;
        ListNode h2 = l2;
        int remainder = 0, sum = 0;
        boolean flag = true;
        while (h1 != null || h2 != null) {
            if (h1 != null){
                sum += h1.val;
            }

            if (h2 != null){
                sum += h2.val;
            }
            sum += remainder;

            remainder = sum / 10;

            if (sum > 9){
                sum -= 10;
            }

            if (h1 != null){
                flag = true;
                h1.val = sum;
                if (h1.next == null && h2 == null && remainder > 0){
                    h1.next = new ListNode(remainder);
                    break;
                }
                h1 = h1.next;
            }

            if (h2 != null){
                flag = false;
                h2.val = sum;
                if (h2.next == null && h1 == null && remainder > 0){
                    h2.next = new ListNode(remainder);
                    break;
                }
                h2 = h2.next;
            }
            sum = 0;
        }

        return flag ? l1:l2;
    }
}
