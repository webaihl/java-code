package org.example.code.tree;

import org.example.code.helper.TreeNode;
import org.example.code.helper.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author web
 * @date 2022年08月18日
 */
public class MinDepth111 {

    public static void main(String[] args) {
        MinDepth111 minDepth = new MinDepth111();
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = Utils.buildTree(arr);
        System.out.println(minDepth.getMinDepth(treeNode));//2
        arr = new Integer[]{2,null,3,null,4,null,5,null,6};
        treeNode = Utils.buildTree(arr);
        System.out.println(minDepth.getMinDepth(treeNode));//5
    }

    public int getMinDepth(TreeNode root) {
       return 0;
    }
}
