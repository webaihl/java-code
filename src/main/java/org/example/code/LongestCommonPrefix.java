package org.example.code;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        args = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(args));
        args = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(args));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        // 假设第一个为子前缀
        String prefix = strs[0];
        for (String items :strs){
            while (!items.startsWith(prefix)){
                //前缀慢慢变短直到匹配，或者无任何匹配直接跳出
                prefix = prefix.substring(0,prefix.length()-1);
            }
            // 其中没有一个字符与前缀匹配的直接跳出
            if (prefix.length() == 0) break;
        }
        return prefix;
    }
}
