package org.example.code;

import org.example.code.helper.ListNode;

import java.util.Objects;

/**
 * @author web
 * @date 2022年06月08日
 */
public class RmDuplicatesLinkedSort83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode p = head;
        ListNode q = head;
        while (q != null){
            if (!Objects.equals(p.val, q.val)){
                p.next = q;
                p = p.next;
            }
            q = q.next;
        }
        // p此时指向不重复字段的第一个，直接舍弃第二个之后的重复节点，1,2,5,5,5
        p.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(2);
        ListNode l23 = new ListNode(3);
        ListNode l24 = new ListNode(3);
        l1.next = l21;
        l21.next = l22;
//        l22.next = l23;
//        l23.next = l24;
        ListNode listNode = new RmDuplicatesLinkedSort83().deleteDuplicates(l1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
