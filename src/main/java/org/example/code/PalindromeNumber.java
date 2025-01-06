package org.example.code;

import java.util.stream.IntStream;

/**
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        IntStream.rangeClosed(999,999).filter(PalindromeNumber::isPalindrome2).forEach(System.out::println);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        String xStr = String.valueOf(x);
        char[] xChars = xStr.toCharArray();
        for (int i = 0; i < xChars.length / 2; i++) {
            if (xChars[i] != xChars[xChars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        // 0 是回文数
        if (x == 0) return true;
        // 负数和除 0 以外以 0 结尾的数都不是回文数
        if (x < 0 || x % 10 == 0) return false;
        // 记录 x 后一半的翻转，如 x = 4334，reversed = 43；x = 54345，reversed = 54
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        // x有偶数位和奇数位两种情况 999 9999
        return x == reversed || x == reversed / 10;
    }
}
