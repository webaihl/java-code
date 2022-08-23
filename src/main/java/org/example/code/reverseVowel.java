package org.example.code;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author web
 * @date 2022年08月22日
 */
public class reverseVowel {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0,j= chars.length - 1;
        while (i<j) {
            char ci = chars[i];
            char cj = chars[j];
            if (!vowels.contains(chars[i])){
                i++;
                continue;
            }else if (!vowels.contains(chars[j])){
                j--;
                continue;
            }
            chars[i++] = cj;
            chars[j--] = ci;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new reverseVowel().reverseVowels("leetcode"));//leotcede
    }
}
