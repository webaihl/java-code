package org.example.code;

import org.example.code.helper.ListNode;
import org.example.code.helper.Utils;

/**
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 0 <= Node.val <= 9
 */
public class PalindromeLinked {

    public static void main(String[] args) {
       // System.out.println(isPalindrome(Utils.list2Linked(new Integer[]{1,0,1,1})));
        System.out.println(isPalindrome(Utils.list2Linked(new Integer[]{1,3,2,0})));
        System.out.println(isPalindrome(Utils.list2Linked(new Integer[]{1,1,0})));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        int middle = -1; int xor = 0; int num = 0;
        while (low != null){
            num++;
            xor = xor ^ low.val;
            low = low.next;
            if (fast != null && fast.next != null){
                fast = fast.next.next;
                middle = low.val;
            }
        }
        return xor == 0 || (num % 2 != 0 && xor == middle) || middle == -1;
    }

}
