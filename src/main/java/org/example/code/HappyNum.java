package org.example.code;

import java.util.HashMap;
import java.util.Map;

/**
 * [202] 快乐数
 * @author web
 * @date 2022年07月14日
 */
public class HappyNum {
    public static void main(String[] args) {
        System.out.println(isHappy(10));
        System.out.println(isHappy(2));
        System.out.println(isHappy(7));
        System.out.println(isHappy(16));
    }
    public static boolean isHappy(int n){
        int result = 0;
        while (n != 0){
            int item = n % 10;
            result += item*item;
            n /= 10;
            if (n == 0 && result > 9){
                n = result;
                result = 0;
            }
        }
        return result == 1 || result == 7;
    }
}
