package org.example.code;

/**
 * 数组递归求和
 */
public class SumArray {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4};
        System.out.println(sum(arr, 0));
    }

    public static int sum(int[] arr,int l){
        if (l == arr.length) {
            return 0;
        }
        int x = sum(arr,l+1);
        return arr[l]+x;
    }
}
