package org.example.code.tree.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Subsets78.java
 * @Description 回溯法
 * @createTime 2022年09月19日 21:36:00
 * @linl <a href="https://leetcode.cn/problems/subsets/description/">90</a>
 */
public class Subsets90 {

    public static void main(String[] args) {
        Subsets90 subsets90 = new Subsets90();
        System.out.println(subsets90.subsets(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);//包含重复元素，排序便于判断
        backtrack(res, new ArrayList<>(),nums,0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> level, int[] nums, int start) {
        res.add(new ArrayList<>(level)); // 使用新变量存储结果，避免tmp修改导致结果改变
        for (int i = start; i < nums.length; i++) { //start一直往后，避免同一个
            if (i != start && nums[i] == nums[i-1]) continue; //同一个组合(level)，需要判断元素重复 12(1)、12(2)
            level.add(nums[i]);//自身也是子集
            backtrack(res,level,nums,i + 1);
            level.remove(level.size() - 1);
        }
    }

    //mask 方法

}
