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
//        String s1 = "()[]{}";
//        String s2 = "()[]{}";
//        String s3 = "(]";
//        System.out.println(isValid(s1));
//        System.out.println(isValid(s2));
//        System.out.println(isValid(s3));

        System.out.println(getMin("))))"));
        System.out.println(getMin(")("));
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

    /**
     * 需要补全多少个括号，保证s有效
     * @param s 原字符
     * @return 数量
     */
    public static int getMin(String s){
        char[] chars = s.toCharArray();
        int rightNum = 0, leftNum = 0;//需要的左右括号数量
        for (char c: chars){
            if (c == '('){
                rightNum++;
            }else if (rightNum == 0){
                leftNum++;
            }else {
                rightNum--;
            }
        }

        return rightNum + leftNum;
    }
}
