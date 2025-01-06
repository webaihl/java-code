package org.example.code.sort;

import org.example.code.helper.Utils;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SelectSort.java
 * @Description 快排
 * @createTime 2022年10月14日 12:34:00
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {2,3,4,1,4,7,5};
        sort(arr);
        Utils.printArr(arr);
    }

    private static void sort(int[] arr) {
        doSort(arr, 0);
    }

    private static void doSort(int[] arr, int start) {
        if (start == arr.length){
            return;
        }

        int index = findSmallestIndex(arr, start);
        swap(arr,start,index);
        doSort(arr, start+1);
    }

    private static void swap(int[] arr, int start, int index) {
        Utils.swap(arr, start ,index);
    }

    private static int findSmallestIndex(int[] arr, int start) {
        int smallerIndex = start;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] < arr[smallerIndex]){
                smallerIndex = i;
            }
        }
         return smallerIndex;
    }


}
