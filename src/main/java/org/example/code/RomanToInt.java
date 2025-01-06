package org.example.code;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV") == 1994);
        System.out.println(romanToInt("III") == 3);
        System.out.println(romanToInt("IV") == 4);
        System.out.println(romanToInt("IX") == 9);
        System.out.println(romanToInt("LVIII") == 58);
    }

    public static Map<String, Integer> ROMAN_INT_MAP = new HashMap<>();

    static {
        ROMAN_INT_MAP.put("I", 1);
        ROMAN_INT_MAP.put("V", 5);
        ROMAN_INT_MAP.put("X", 10);
        ROMAN_INT_MAP.put("IV", 4);
        ROMAN_INT_MAP.put("IX", 9);
        ROMAN_INT_MAP.put("L", 50);
        ROMAN_INT_MAP.put("C", 100);
        ROMAN_INT_MAP.put("XL", 40);
        ROMAN_INT_MAP.put("XC", 90);
        ROMAN_INT_MAP.put("D", 500);
        ROMAN_INT_MAP.put("M", 1000);
        ROMAN_INT_MAP.put("CD", 400);
        ROMAN_INT_MAP.put("CM", 900);
    }

    public static int romanToInt(String roman) {
        String[] strs = roman.split("");
        int res = 0;
        for (int i = 0; i < strs.length - 1; i++) {
            if (ROMAN_INT_MAP.containsKey(strs[i] + strs[i + 1])) {
                res += ROMAN_INT_MAP.get(strs[i] + strs[i + 1]);
                i++;
            } else {
                res += ROMAN_INT_MAP.get(strs[i]);
            }
        }
        return res;
    }
}
