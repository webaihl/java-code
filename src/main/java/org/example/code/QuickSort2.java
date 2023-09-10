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
//        sort(arr, 0, arr.length-1);
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a, int l, int r) {
        if (r <= l) { return; }
        int p = partion(a, l, r);
        sort(a, l, p - 1);
        sort(a, p + 1, r);
    }
    private static int partion(int[] a, int l, int r) {
//        int pivot = r;
        int i = l;
        int j = l;
        while (j < r) {
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

    public static void selectSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            int minValIndex = i;//每次循环默认i是最小的索引
            for (int j = i+1;j<arr.length;j++){
                if (arr[minValIndex] > arr[j]){
                    minValIndex = j;
                }
            }
            if (i != minValIndex){
                swap(arr, minValIndex,i);
            }
        }
    }

    public static void insertSort(int[] arr){
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }


    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
