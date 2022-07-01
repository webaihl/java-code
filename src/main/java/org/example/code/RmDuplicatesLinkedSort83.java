package org.example.code;

import org.example.code.helper.ListNode;

import java.util.Objects;

import static org.example.code.helper.Utils.list2Linked;

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
        ListNode l1 = list2Linked(new Integer[]{1,1, 2, 3,3});
        ListNode listNode = new RmDuplicatesLinkedSort83().deleteDuplicates(l1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
