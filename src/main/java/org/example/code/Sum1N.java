package org.example.code;

public class Sum1N {

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
