package org.example.code.helper;

/**
 * @author web
 * @date 2022年08月10日
 */

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(Integer val) {
        this.val = val;
    }

    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
