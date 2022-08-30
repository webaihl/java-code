package org.example.code;

import org.example.code.helper.ListNode;
import org.example.code.helper.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.example.code.helper.Utils.swap;

/**
 * @author web
 * @date 2022年08月30日
 */
public class Wdqb {

    public static void main(String[] args) {
//        int[] a = {1, 3, 5, 3, 2, 4};
//        new Wdqb().foo(a,0,a.length-1);
//        System.out.println(Arrays.toString(a));
//        a = new int[]{1, 3, 4, 5};
//        System.out.println(new Wdqb().findKthPositive(a,2));
//        System.out.println(Arrays.toString(new Wdqb().twoSum(a, 6)));
//        System.out.println(new Wdqb().isPalindrome(54345));

//        Utils.printLinked(new Wdqb().removeNthFromEnd(Utils.list2Linked(new Integer[]{1,2,3,4,5}),2));
        int[] ints = {1, 2, 3,0,0,0};
        new Wdqb().merge(ints,6,new int[]{1,2,3},3);
        System.out.println(Arrays.toString(ints));
    }

    public void foo(int[] arr, int l, int r){
        if (r <= l) return;
        int p = partition(arr,l,r);
        foo(arr,l,p-1);
        foo(arr,p+1,r);
    }
    private int partition(int[] arr, int l, int r) {
        int i = l;
        int j = l;
        while (j < r){
            if (arr[j] < arr[r]){
                swap(arr,i,j);
                i++;
            }
            j++;
        }
        swap(arr,i,r);
        return i;
    }
    public int findKthPositive(int[] arr, int k) {
        for (int j : arr) {
            if (j <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diff2IndexMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (diff2IndexMap.containsKey(nums[i])){
                return new int[]{diff2IndexMap.get(nums[i]),i};
            }
            diff2IndexMap.put(target - nums[i],i);
        }

        return new int[0];
    }
    public boolean isPalindrome(int x) {
        if (x == 0){
            return true;
        }

        if (x < 0 || x % 10 == 0){
            return false;
        }

        int remainder = 0;
        while (remainder < x){
            remainder = remainder*10 + x % 10;
            x /= 10;
        }
        return x == remainder || x == remainder / 10;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode first = head, mid = head,last = head;
        int k = 0,len;
        while (last != null && last.next != null){
            last = last.next.next;
            mid = mid.next;
            k++;
        }
        len = 2 * k;
        if (last != null){
            len += 1;
        }
        if (n >= len){
            return head.next;
        }
        int step = len - n;
        if (step > k) {
            first = mid;
            step = step - k;
        }
        for (int j = 0; j < step - 1; j++) {
            first = first.next;
        }

        first.next = first.next.next;
        return head;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }

}
