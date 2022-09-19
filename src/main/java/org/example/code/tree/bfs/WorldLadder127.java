package org.example.code.tree.bfs;

import java.util.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName WorldLadder127.java
 * @Description 127
 * @createTime 2022年09月19日 15:46:00
 * @link <a href="">https://leetcode.cn/problems/word-ladder/description</a>
 */
public class WorldLadder127 {

    /**
     * 单词接龙，每个位置遍历其余25个字符，暴力匹配
     * @param beginWord 开始单词
     * @param endWord 目标单词
     * @param wordList 转换过程中出现的字符列表
     * @return 转换多少轮
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> endSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1, n = endWord.length();

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (Objects.equals(cur, endWord)) return step;
                for (int j = 0; j < n; j++) {
                    for (char letter = 'a'; letter <= 'z'; letter++){
                        StringBuilder newItem = new StringBuilder(cur);
                        newItem.setCharAt(j, letter); //尝试替换每个字符，并与end毕竟
                        String newStr = newItem.toString();
                        if (endSet.contains(newStr)){
                            if (Objects.equals(newStr, endWord)) return step+1; //符合直接返回，并+1
                            endSet.remove(newStr);//删除已经匹配的元素，避免
                            queue.add(newStr); //符合要求，对其进行下一轮转换
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
