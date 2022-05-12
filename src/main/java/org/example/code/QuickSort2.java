package org.example.code;

import java.util.Arrays;

/**
 * @author web
 * @date 2022年05月12日
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,2,4,6};
//        int[] arr = {1,2,3,2,4,7,-1,98,9};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a, int l, int r) {
        if (r <= l) {
            return;
        }
        int p = partion(a, l, r);
        sort(a, l, p - 1);
        sort(a, p + 1, r);
    }

    private static int partion(int[] a, int l, int r) {
//        int pivot = r;
        int i = l;
        int j = l;
        while (j <= r - 1) {
            if (a[j] <= a[r]) {
                swap(a, i, j);
                i++;
            }
            j++;
        }
        // [l,i) 小于pivot
        // [i,j) 大于pivot
        // [j,r) 有大有小
        // [r]

        swap(a, i, r);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
