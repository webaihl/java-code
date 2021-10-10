package com.web.algorithm.other;

/**
 * 删除链表中指定的所有val
 */
public class RemoveLinkedListEle203 {

    private class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public  ListNode solution1(ListNode head, int val){

        //增加虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public ListNode solution2(ListNode head, int val){
        if (head == null) return null;

        ListNode res = solution2(head.next, val);
        //head.next = solution2(head.next, val);
        //return head.val == val?head.next:head;
        if (head.val == val){
            return res;
        }else {
            head.next = res;
            return head;
        }
    }

    public ListNode solution3(ListNode head, int val){

        while (head != null && head.val == val){
               head = head.next;
        }

        if (head == null){
            return null;
        }

        //确定所有节点都有前驱节点
        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }

        return head;
    }
}
