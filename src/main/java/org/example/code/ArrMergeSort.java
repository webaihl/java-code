package org.example.code;

import java.util.Arrays;

/**
 * @author web
 * @date 2022年05月11日
 */
public class ArrMergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 2, 6, 4, 8, 3, 8};
        //System.out.println(Arrays.toString(Arrays.copyOfRange(a, 1, 2)));
        mergeSort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a, int l, int r) {
        if (r - l <= 1) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(a, l, m - 1);
        mergeSort(a, m, r);
        merge(a, l, m, r);
    }

    private static void merge(int[] a, int l, int m, int r) {

        int[] b1 = new int[m - l + 1];
        int[] b2 = new int[r - m + 1];
        System.arraycopy(a, l, b1, 0, m - l);
        System.arraycopy(a, m, b2, 0, r - m);
        b1[b1.length - 1] = Integer.MAX_VALUE;
        b2[b2.length - 1] = Integer.MAX_VALUE;
        int i = 0, j = 0, k = l;
        while (r != k) {
            if (b1[i] <= b2[j]) {
                a[k] = b1[i];
                i++;
            } else {
                a[k] = b2[j];
                j++;
            }
            k++;
        }
    }
}
