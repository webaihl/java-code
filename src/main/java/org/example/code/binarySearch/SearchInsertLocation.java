package org.example.code.binarySearch;

/**
 * 35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsertLocation {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 9};
        int val = 2;
        System.out.println(location2(arr, val));
    }

    /**
     * @param nums   无重复元素的升序排列数组
     * @param target 目标值
     * @return 结果
     */
    public static int location(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;
        //相遇不相等说明target可以插入到这里
        for (int i = 0; i < nums.length && l <= r; i++) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;//r+1;
    }

    public static int location2(int[] nums, int target) {
        int l = -1, r = nums.length,m;
        while (l + 1 != r){
            m = (l+r) / 2;
            if (nums[m] < target){
                l = m;
            }else {
                r = m;
            }
        }
        return r;
    }
}
