package org.example.code;

import org.example.code.helper.ListNode;

/**
 * @author web
 * @date 2022年06月10日
 */
public class RemoveElements203 {

    /**
     * todo more information
     * @param head 链表的头节点
     * @param val 整数
     * @return 并返回 新的头节点 。
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }

        ListNode res = removeElements(head.next, val);
        if (head.val == val){
           return res;
        }else {
            head.next = res;
            return head;
        }
    }

    public ListNode removeElements2(ListNode head, int val) {
        //虚拟头节点，避免节点为空的判断
       ListNode dummy = new ListNode(-1,head);
       // 前驱节点，用来跳过val节点
       ListNode prev = new ListNode(-1,dummy);
       while (prev.next != null){
           if (prev.next.val == val){
               prev.next = prev.next.next;
           }else {
               prev = prev.next;
           }
       }

       return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(2);
        ListNode l23 = new ListNode(3);
        ListNode l24 = new ListNode(3);
        l1.next = l21;
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        ListNode listNode = new RemoveElements203().removeElements(l1,1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
