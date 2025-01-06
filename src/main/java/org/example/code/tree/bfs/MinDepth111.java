package org.example.code.tree.bfs;

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
        System.out.println(minDepth.minDepth(treeNode));//2

        arr = new Integer[]{2,null,3,null,4,null,5,null,6};
        treeNode = Utils.buildTree(arr);
        System.out.println(minDepth.minDepth(treeNode));//5
    }

    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null) return getMinDepth(root.right) + 1; //左边为空，遍历右边
        if (root.right ==  null) return getMinDepth(root.left) + 1;//右边为空遍历左边
        return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
    }

    public int getMinDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size(); //保存当前层的长度，便于一层遍历完后继续，不可写在for中，不然会变化后一直遍历
            for (int i = 0; i < size;i++){
                TreeNode cur = queue.poll();
                if (cur.right == null && cur.left == null) return depth;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            depth += 1;//一层遍历完了
        }
        return depth;
    }


}
