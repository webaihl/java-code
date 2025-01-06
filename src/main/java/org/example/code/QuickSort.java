package org.example.code;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,4,7,-1,98,9};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr,int left,int right) {
        if (left >= right) {return;}
        int partition = partition(arr,left,right);
        sort(arr,left,partition-1);
        sort(arr,partition+1,right);
    }

    public static int partition(int[] arr, int left, int right){
        assert left <= right: "left must less than right";
        int i = left, j = right, v = arr[left];
        while(i != j){
            //先移动右指针,碰到<=v时跳出循环,保证i=j时，
            // arr[i]=arr[j]<=v,便于T1步骤与基准值v的交换
            while (i < j && v < arr[j]) {j--;}

            //大于v时停止
            while (i < j && v >= arr[i]) {i++;}

             if (i < j){ swap(arr,i,j);}
        }
        //T1,此时i=j,对应值均小于或等于v(arr[left])
        swap(arr,left,j);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
