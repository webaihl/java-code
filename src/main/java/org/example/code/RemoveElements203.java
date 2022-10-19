package org.example.code;

import org.example.code.helper.ListNode;
import org.example.code.helper.Utils;

import static org.example.code.helper.Utils.list2Linked;

/**
 * @author web
 * @date 2022年06月10日
 */
public class RemoveElements203 {

    /**
     *
     * @param head 链表的头节点
     * @param val  整数
     * @return 并返回 新的头节点 。
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public ListNode removeElements2(ListNode head, int val) {
        //虚拟头节点，避免节点为空的判断
        ListNode dummy = new ListNode(null, head);
        // 前驱节点，用来跳过val节点
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = list2Linked(new Integer[]{1, 1, 2, 3, 1, 3});

        ListNode listNode = new RemoveElements203().removeElements2(l1, 1);
        Utils.printLinked(listNode);

//        ListNode h = new ListNode(-1, null);
//        ListNode p = h;
//        ListNode tmp = new ListNode(2,null);
//        p.next = tmp;
//        System.out.println();
    }
}
