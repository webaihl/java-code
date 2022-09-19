package org.example.code.tree.dfs;

import org.example.code.helper.TreeNode;
import org.example.code.helper.Utils;

/**
 * @author web
 * @date 2022年08月10日
 */

public class MaxDepth104 {


    public static void main(String[] args) {
        MaxDepth104 maxDepth104 = new MaxDepth104();
        System.out.println(maxDepth104.maxDepth(Utils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(maxDepth104.maxDepth(Utils.buildTree(new Integer[]{})));
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        //+1 递归累加初始值
        return Math.max(maxDepth(root.right),maxDepth(root.left)) + 1;
    }
}
