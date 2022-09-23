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
        int[] ints = {2,2,2,2};
        Wdqb wdqb = new Wdqb();
//        new Wdqb().merge(ints,3,new int[]{1,2,3},3);
//        System.out.println(Arrays.toString(ints));
//        System.out.println(new Wdqb().longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
//        System.out.println(new Wdqb().longestCommonPrefix2(new String[]{"dog","racecar","car"}));
//        System.out.println(new Wdqb().longestCommonPrefix2(new String[]{"a"}));
//        int i1 = wdqb.removeElement(ints, 2);
//        for (int i = 0; i < i1; i++) {
//            System.out.print(ints[i]);
//        }
//        System.out.println();
//        ints = new int[]{1,2,3};
//        i1 = wdqb.removeDuplicates(ints);
//        for (int i = 0; i < i1; i++) {
//            System.out.print(ints[i]);
//        }
//

        System.out.println(wdqb.fastPower(4, 4));
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
        int k = nums1.length - 1;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[k] = nums1[m - 1];
                k--;
                m--;
            } else {
                nums1[k] = nums2[n - 1];
                k--;
                n--;
            }
        }
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        char cur;
        for (int i = 0; i < strs[0].length() ; i++) {
            cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1 || cur != strs[j].charAt(i)){
                    return res.toString();
                }
            }
            res.append(cur);
        }
        return res.toString();
    }
    public String longestCommonPrefix2(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //每个元素都对自己进行适配，知道符合为止
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0,prefix.length()-1);
            }
            if (prefix.length() == 0) {
                return prefix;
            }
        }
        return prefix;
    }

    public int removeElement(int[] nums, int val) {

        int i = 0, j = nums.length;
        while (i < j){
            if (nums[i] == val){
                nums[i] = nums[j - 1];
                j--;
            }else {
                i++;
            }
        }
        return j;
    }

    public int removeDuplicates(int[] nums) {

        int i = 0, j = 1;
        while (j < nums.length){
            if (nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        return i+1;
    }

    public int fastPower(int a, int n){
        int r = 1;
        while (n != 0){
            if ((n & 1) == 1){
                r = r * a;
            }
            a = a * a;
            n = n>>1;
        }
        return r;
    }
}
