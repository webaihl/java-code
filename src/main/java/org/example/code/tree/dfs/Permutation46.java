package org.example.code.tree.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Permutation46.java
 * @Description
 * @createTime 2022年09月19日 22:46:00
 * @link <a href="https://leetcode.cn/problems/permutations/description/">46</a>
 */
public class Permutation46 {

    public static void main(String[] args) {
        Permutation46 permutation46 = new Permutation46();
        System.out.println(permutation46.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(),nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> level, int[] nums) {
        if (level.size() == nums.length) res.add(new ArrayList<>(level)); //长度相等的情况下新增作为结果add
        for (int i = 0; i < nums.length; i++) { //因为是全排列，所以每次从头开始
            if (level.contains(nums[i])) continue;//该数字被使用了,不能再重新使用，避免出现栈溢出 11111..., 11111...,11111..., .。。。。
            level.add(nums[i]);//自身也是子集
            backtrack(res,level,nums);
            level.remove(level.size() - 1);
        }
    }

}
