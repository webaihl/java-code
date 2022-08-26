package org.example.code;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,4,5};
        int val = 5;
        //System.out.println(searchRecursive(arr, 0, arr.length-1, val));
//        System.out.println(searchLoopFor(arr, val));
        System.out.println(searchLoopWhile(arr, val));
    }
    public static int searchRecursive(int[] arr, int start, int end, int val){

        if (start > end) { return -1; }
        int middle = start + (end - start) / 2;
        if (arr[middle] < val){
            return searchRecursive(arr,middle+1,end,val);
        }else if (arr[middle] > val){
            return searchRecursive(arr, start, middle-1, val);
        }else {
            return middle;
        }
    }
    public static int searchLoopFor(int[] arr, int val){
        int middle = arr.length / 2;
        for (int i = 0; i < arr.length; i++) {
            if (arr[middle] > val){
                middle = (middle - 1) / 2;
            }else if(arr[middle] < val){
                middle = (arr.length + middle) / 2;
            }else {
                return middle;
            }
        }
        return -1;
    }
    public static int searchLoopWhile(int[] arr, int val){
        int l = 0,r = arr.length;
        while (l < r){
            int m = l + (r - l) / 2;
            if (arr[m] == val){
                return m;
            }
            if (arr[m] < val){
                l = m + 1;
            }else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static int wdqb(int[] arr,int target){
        return 0;
    }
}
