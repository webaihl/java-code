package org.example.code;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SubArrayMaxSum.java
 * @Description lc53  请你找出一个具有最大和的连续子数组（子数组最少包含一个元素）
 * @createTime 2022年10月19日 16:51:00
 */
public class SubArrayMaxSum {

    public static void main(String[] args) {
        SubArrayMaxSum maxSum = new SubArrayMaxSum();
        System.out.println(maxSum.maxSubArray_TLE_err(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSum.maxSubArray_dp(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSum.maxSubArray_dp2(new int[]{5,4,-1,7,8}));
    }

    public int maxSubArray_TLE_err(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int csum = 0;
            for (int j = i; j < nums.length; j++) {
                csum += nums[j];
                if (csum > max){
                    max = csum;
                }
            }
        }
        return max;
    }

    public int maxSubArray_dp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            //存储前段和，根据其决定最大值
            //前i-1和的正负，决定i和的max
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }


    public int maxSubArray_dp2(int[] nums) {
        int sumOfPrefix = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumOfPrefix = Math.max(nums[i],sumOfPrefix+nums[i]);
            if (max < sumOfPrefix){
                max = sumOfPrefix;
            }
        }
        return max;
    }


}


