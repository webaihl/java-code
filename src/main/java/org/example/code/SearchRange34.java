package org.example.code;

import org.example.functional.predicate.Predicate;

import java.util.Arrays;

/**
 * @author web
 * @date 2022年05月10日
 */
public class SearchRange34 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3,5,5,5,6}, 5)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3,4,5,6}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3,4,5,6}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3,4,5,8}, 8)));
    }
    public static int[] searchRange(int[] nums, int target) {

        int l = -1;
        int r = nums.length;
        int[] res = new int[]{-1,-1};

        while (l + 1 != r) {
            int m = (l + r) / 2;
            if (isBlue(() -> nums[m] <= target)) {
                l = m;
            } else {
                r = m+1;
            }
        }

        res[1] = l;

        l = -1;
        r = nums.length;
        while (l + 1 != r) {
            int m = (l + r) / 2;
            if (isBlue(() -> nums[m] < target)) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        res[0] = r;

        return res;
    }

    public static boolean isBlue(Predicate p) {
        return p.test();
    }

}
