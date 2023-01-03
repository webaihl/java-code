package org.example.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName codeTest.java
 * @Description
 * @createTime 2022年11月29日 22:27:00
 */

public class LeetcodeTest {

    @Test
    void binaryString1758(){
        System.out.println(minOperations("0100"));
        System.out.println(minOperations("10"));
        System.out.println(minOperations("1111"));
    }

    public int minOperations(String s) {
        char[] items = s.toCharArray();
        int count = 0;
        for(int i=0;i<items.length;i++){
            //先按010101...来
            if(items[i]-'0' == i%2) continue;
            count++;
        }
        //若干这种情况修改数量较多，则按101010... 两者修改的次数之和等于其长度
        return Math.min(count, s.length()-count);
    }

    public boolean check(int[] nums) {
        // 20 30 40 5 6 7
        for(int i = 0; i < nums.length - 1;i++){
            var l = new ArrayList<String>();
            var h = new HashMap<Integer,Integer>();
        }

        return true;
    }

    // https://leetcode.cn/problems/number-of-different-integers-in-a-string/
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<String>();
        int n = word.length(), p1 = 0, p2;
        while (true) {
            // p1 开始位置
            while (p1 < n && !Character.isDigit(word.charAt(p1))) {
                p1++;
            }
            if (p1 == n) {
                break;
            }
            p2 = p1;
            //p2 结束位置
            while (p2 < n && Character.isDigit(word.charAt(p2))) {
                p2++;
            }
            // 去除前导 0
            while (p2 - p1 > 1 && word.charAt(p1) == '0') {
                p1++;
            }
            set.add(word.substring(p1, p2));
            p1 = p2;
        }
        return set.size();
    }

    @Test
    public void numDifferentIntegersTest(){
        System.err.println(numDifferentIntegers("0a0"));//1
        System.err.println(numDifferentIntegers("gi851a851q8510v"));//2
        System.err.println(numDifferentIntegers("a123bc34d8ef34"));//3
        System.err.println(numDifferentIntegers("leet1234code234"));//2
        System.err.println(numDifferentIntegers("a1b01c001"));//1
        System.err.println(numDifferentIntegers("abcsbebr"));//0
        System.err.println(numDifferentIntegers("abcsbebr1"));//tail 1
    }

    // https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three/
    // 1 <= n <= 107
    // 三进制，检查是否二进制都是由01组成
    public boolean checkPowersOfThree(int n) {
        while (n > 0){
            if (n % 3 > 1){
                return false;
            }
            n /= 3;
        }
        return true;
    }

    // https://leetcode.cn/problems/longest-substring-without-repeating-characters/submissions/
    @Test
    public void lengthOfLongestSubstringTest(){
        Assertions.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        Assertions.assertEquals(3, lengthOfLongestSubstring("pwwkew"));

        Assertions.assertEquals(3, lengthOfLongestSubstring2("abcabcbb"));
        Assertions.assertEquals(1, lengthOfLongestSubstring2("bbbbb"));
        Assertions.assertEquals(3, lengthOfLongestSubstring2("pwwkew"));
    }

    /**
     *  除了使用双指针以外，我们还可以使用队列来解决，这个原理也很简单。
     *  就是把元素不停的加入到队列中，如果有相同的元素，就把队首的元素移除，
     *  这样我们就可以保证队列中永远都没有重复的元素，
     *  每次计算的时候我们都要记录下最大长度，
     *  最后再返回即可。
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        //用链表实现队列，队列是先进先出的
        Queue<Character> queue = new LinkedList<>();
        for (char c: s.toCharArray()){
            //如果有重复的，队头出队，这里通过while循环，
            //如果还有重复的就继续出队，直到队列中没有
            // 重复的元素为止
            while (queue.contains(c)){
                queue.poll();
            }
            //不重复直接添加
            queue.add(c);
            //记录下最大长度
            max = Math.max(max, queue.size());
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        var max = 0;
        var j = 0; //第二指针,只能增大不能减小
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                // 重复元素位置的下一个值和j这两个值的最大值
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            //记录下各个阶段最大值
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
