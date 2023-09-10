package org.example.bobo.array;

import org.example.code.helper.ListNode;
import org.example.code.helper.Utils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ArrayCategoryTest.java
 * @Description
 * @createTime 2023年08月29日 21:07:00
 */
public class ArrayCategoryTest {

    /**
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     */
    @Test
    public void moveZero() {
        int[] arr = new int[]{1, 1, 1, 0, 1, 0, 3, 12};
        int zeroIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (zeroIdx != i) {
                    Utils.swap(arr, zeroIdx, i);
                }
                // 当前[i]不为0，zeroIndex同步向前寻找
                zeroIdx++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
     */
    @Test
    public void removeElement27() {
        int[] nums = new int[]{1,2,3,3,5};
        int val = 3;
        int j = nums.length - 1;
        for (int i = 0; i < nums.length && i <= j; i++) {
            if (nums[i] == val){
                nums[i] = nums[j--];
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(j+1);
    }

    @Test
    //todo 80
    public void removeDuplicatedElementFromSortedArr26() {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        int zeroIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[zeroIdx] = arr[i];
                zeroIdx++;
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    //  todo 88、215
    public void sortColor75() { // 数组中只出现0、1、2，计数排序、三路快排
        int[] arr = new int[]{0, 1, 0, 1, 2, 1, 2, 0};
        int zero = -1; // arr[0, zero] == 0
        int two = arr.length; // arr[i,two-1] == 2
        for (int i = 0; i < two; ) { // i --> 2的左边界
            if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 2) {
                two--;
                Utils.swap(arr, i, two);
            } else if (arr[i] == 0) {
                zero++;
                Utils.swap(arr, i, zero);
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 滑动窗口
     */
    @Test
    public void minNumSizeSubArrSum209() {
        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        int l = 0, r = -1; // 窗口大小 [l,r]
        int res = arr.length + 1;// 结果,默认是数组长度
        int sum = 0;
        while (l < arr.length) {
            if (r < arr.length - 1 && sum < target) {
                r++;
                sum += arr[r];
            } else { //sum >= target
                sum -= arr[l];
                l++;
            }
            if (sum >= target)
                res = Math.min(res, r - l + 1); //符合要求时，之前的结果与当前窗口大小取 最小值
        }

        if (res == arr.length + 1) System.out.println("have no solution");
        System.out.println(res);
    }

    // todo 438 76
    @Test
    public void LongestWithoutDupSubStr3(){
        Set<Character> existsCharSet = new HashSet<>();
        int l = 0,r = -1; // [l..r]
        int count = 0;
        String s = "hello";
        char[] charArray = s.toCharArray();
        while (l < s.length()){
            // 判断下一个值是否重复，决定是否右边界是否往下走,保证[l..r]无重复字符
            if(r < s.length() - 1 && !existsCharSet.contains(charArray[r+1])){
                r++;
                existsCharSet.add(charArray[r]);
            }else {
                existsCharSet.remove(charArray[l]);
                l++;
            }
            count = Math.max(count, r - l + 1);
        }
        System.out.println(count);
    }
    /**
     * todo 125、344、345、11
     * 1、双重循环
     * 2、循环+二分查找
     * 3、对撞指针
     */
    @Test
    public void twoSumInSortArr167() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int target = 12;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                System.out.println(Arrays.toString(new int[]{i + 1, j + 1}));
                break;
            } else if (sum > target) { //大了，j前移
                j--;
            } else { // 小了，i后移
                i++;
            }
        }
    }

// --------linked------------------------------------------

    /**
     * 链表反转 3指针
     * todo 83 2 445
     */
    @Test
    public void reverseLinkedList206(){
        ListNode head = Utils.list2Linked(new Integer[]{1, 2, 3, 4});
        ListNode pre = null, cur = head,next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        Utils.printLinked(pre);
    }

    /**
     * todo 82 83 21
     * 删除节点的时候，虚拟头节点
     * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/">...</a>
     */
    @Test
    public void removeValInLinkedList203(){
        ListNode head = Utils.list2Linked(new Integer[]{4,1,2,2, 3, 4});
        int val = 2;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null){
            if (cur.next.val == val){
               ListNode delNode = cur.next;
               cur.next = delNode.next;
               delNode.next = null;
            }else {
                cur = cur.next;
            }
        }

        Utils.printLinked(dummyHead.next);
    }

    /**
     * todo 25 147 148
     *
     * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/">两两交换链表节点</a>
     */
    @Test
    public void swapNodesInPairs24(){
        ListNode head = Utils.list2Linked(new Integer[]{1,2,3,4,5});
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead; // 要交换节点的前一个节点
        while (pre.next != null && pre.next.next != null){
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode post = node2.next;//要交换节点的后一个节点

            node2.next = node1;
            node1.next = post;
            pre.next = node2;

            pre = node1;
        }

        Utils.printLinked(dummyHead.next);

    }

    /**
     * todo 61 143 234
     * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">删除倒数第k个元素</a>
     */
    @Test
    public void removeNthNodeFromEndOfList19(){
        ListNode head = Utils.list2Linked(new Integer[]{1,2,3,4,5}); //remove 3
        int n = 3;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        while (p.next != null){
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;

        Utils.printLinked(dummyHead.next);

    }

}
