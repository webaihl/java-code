package org.example.code;

import java.util.Objects;

/**
 * @author web
 * @date 2022年06月16日
 */
public class StrStr28 {

    private int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        char[] m1 = haystack.toCharArray();
        char[] m2 = needle.toCharArray();

        for (int i = 0; i < m - n + 1; i++) {
            int a = i, b = 0;
            while (b < n && m1[a] == m2[b]) {
                a++;
                b++;
            }
            if (b == n) {
                return i;
            }
        }

        return -1;
    }

    private int strStr2(String n, String m) {
        int mHash = Objects.hash(m);
        for (int i = 0; i < n.length() -m.length() + 1; i++) {
            if (mHash == Objects.hash(n.substring(i,i+m.length()))){
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        System.out.println(new StrStr28().strStr2("hello", "ll"));
        System.out.println(new StrStr28().strStr2("aaaa", "a"));
        System.out.println(new StrStr28().strStr2("hhha", "a"));
        System.out.println(new StrStr28().strStr2("bbb", "c"));
        System.out.println(new StrStr28().strStr2("bcb", "c"));
        System.out.println(new StrStr28().strStr2("bcb", ""));
    }
}
