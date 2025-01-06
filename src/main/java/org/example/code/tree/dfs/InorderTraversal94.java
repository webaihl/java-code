package org.example.code.tree.dfs;

import org.example.code.helper.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName InorderTraversal94.java
 * @Description
 * @createTime 2022年09月19日 20:46:00
 */
public class InorderTraversal94 {

    // recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }


    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }


    //iterative
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();//先进后出
        while (root != null || !stack.isEmpty()){
            while (root != null){ //把所有的left加入到栈
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;//处理right节点
        }
        return res;
    }
}
