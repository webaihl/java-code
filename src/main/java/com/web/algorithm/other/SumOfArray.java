package com.web.algorithm.other;

/**
 * @author web
 * @version 1.0.0
 * @ClassName SumOfArray.java
 * @Description 数组求和
 * @createTime 2020年09月10日 15:34:00
 */
public class SumOfArray {

    public static void main(String[] args) {
        int[] arr = {10,11,12};
        System.out.println(sum(arr));
    }

    public static int sum(int[] arr){
        return sum(arr, 0);
    }

    //l代表数组的左边界的下标
    private static int sum(int[] arr, int l) {
        if(l == arr.length) return 0;
        int x = sum(arr, l+1);
        return arr[l] + x;
    }
}
