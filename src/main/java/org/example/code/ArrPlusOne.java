package org.example.code;

import java.util.Arrays;

/**
 * @author web
 * @date 2022年06月08日
 */
public class ArrPlusOne {
    public int[] plusOne(int[] digits) {
        int res = 1;
        for (int i = digits.length - 1; i > -1; i--) {

            res += digits[i];

            if (res < 10) {
                digits[i] = res;
                return digits;
            }

            digits[i] = res % 10;
            if (i == 0) {
                int[] newRes = new int[digits.length + 1];
                System.arraycopy(digits, 0, newRes, 1, digits.length);
                newRes[0] = res / 10;
                digits = newRes;
                break;
            }
            res /= 10;
        }

        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ArrPlusOne().plusOne(new int[]{9, 8, 9})));
        System.out.println(Arrays.toString(new ArrPlusOne().plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(new ArrPlusOne().plusOne(new int[]{9, 8, 7})));
        System.out.println(Arrays.toString(new ArrPlusOne().plusOne(new int[]{0})));
    }
}
