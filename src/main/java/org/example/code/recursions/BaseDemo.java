package org.example.code.recursions;

import org.example.code.helper.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BaseDemo.java
 * @Description 递归基础案例 https://segmentfault.com/a/1190000024455045
 * @createTime 2023年02月09日 14:24:00
 */
public class BaseDemo {

    public void recursiveDemo(int n) {
        System.out.println("before: " + n);
        if (n < 3) {
            recursiveDemo(n + 1);
        }

        System.out.println("after: " + n);

    }

    public int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public void printRevers(ListNode root) {
        //（终止条件）
        if (root == null) return;
        //（递归调用）先打印下一个
        printRevers(root.next);
        //（逻辑处理）把后面的都打印完了在打印当前节点
        System.out.println(root.val);
    }

    // 数组sums中所有可以使数字和为target的组合
    public void combinationSum(List<Integer> cur, int[] sums, int target) {
        // 终止条件
        if (target == 0) {
            System.out.println(Arrays.toString(cur.toArray()));
        }
        // 递归逻辑
        for (int i = 0; i < sums.length; i++) {
            //当前值大于target,跳过
            if (target < sums[i]) continue;
            //尝试使用当前值进行递归匹配
            cur.add(sums[i]);
            //递归调用
            combinationSum(cur, sums, target - sums[i]);
            //sums[i]这个数据你用完了，删除，因为cur的值会累计，回溯
            cur.remove(cur.size() - 1);
        }
        // 业务逻辑 (optional)
    }


    public void binary(int[] arr, int index) {
        System.out.println(index);
        if (index == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        arr[index] = 0;
        binary(arr, index + 1);
        arr[index] = 1;
        binary(arr, index + 1);
    }

    // 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
    public void combinationSum3(int n, int k) {
        var res = new ArrayList<List<Integer>>();
        dfs(res, new ArrayList<>(), n, k, 1);
        System.out.println(res);
    }

    private void dfs(List<List<Integer>> res, List<Integer> temps, int n, int k, int start) {
        if (temps.size() == k || n <= 0) {
            if (temps.size() == k && n == 0) {
                res.add(new ArrayList<>(temps));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            temps.add(i);
            dfs(res, temps, n - i, k, i + 1);
            temps.remove(temps.size() - 1);
        }
    }

    public void subsets(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        doFindSubsets(res, new ArrayList<>(), nums, 0);
        System.out.println(res);
    }

    private void doFindSubsets(ArrayList<List<Integer>> res, ArrayList<Integer> temps, int[] nums, int start) {
        //注意这里没有写终止条件，不是说递归一定要有终止条件的吗，这里怎么没写，其实这里的终止条件
        //隐含在for循环中了，当然我们也可以写if(start>nums.length) rerurn;只不过这里省略了。
        res.add(new ArrayList<>(temps));
        for (int i = start; i < nums.length; i++) { //nums的长度终止递归
            temps.add(nums[i]);
            doFindSubsets(res,temps,nums,i+1);
            temps.remove(temps.size()-1);
        }

    }

}