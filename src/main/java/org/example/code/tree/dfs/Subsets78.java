package org.example.code.tree.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Subsets78.java
 * @Description 回溯法
 * @createTime 2022年09月19日 21:36:00
 * @linl <a href="78">https://leetcode.cn/problems/subsets/description/</a>
 */
public class Subsets78 {

    public static void main(String[] args) {
        Subsets78 subsets78 = new Subsets78();
        System.out.println(subsets78.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(),nums,0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> level, int[] nums, int start) {
        res.add(new ArrayList<>(level)); // 使用新变量存储结果，避免tmp修改导致结果改变
        for (int i = start; i < nums.length; i++) { //start一直往后，避免重复
            System.out.println(level);
            level.add(nums[i]);//自身也是子集
            backtrack(res,level,nums,i + 1);
            // todo ?
            level.remove(level.size() - 1);
        }
    }

    //mask 方法

}
