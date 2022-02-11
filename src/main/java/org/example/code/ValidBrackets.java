package org.example.code;

import java.util.*;

//20
public class ValidBrackets {

    private static final Map<Character, Character> map = new HashMap<>();;
    static {
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "()[]{}";
        String s3 = "(]";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
    }

    //todo 28 35
    public static boolean isValid(String s) {
        int n = s.length(); if (n % 2 == 1) { return false; }
        Deque<Character> characters = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if (!characters.isEmpty() && Objects.equals(characters.peekFirst(), map.get(c))){
                characters.poll();
                continue;
            }
            characters.add(c);
        }
        return characters.isEmpty();
    }
}
