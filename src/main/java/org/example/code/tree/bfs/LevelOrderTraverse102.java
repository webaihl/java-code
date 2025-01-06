package org.example.code.tree.bfs;

import org.example.code.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LevelOrderTraverse102.java
 * @Description 102 bfs适合解决搜索最短路径的问题；dfs适合全部解
 * @createTime 2022年09月19日 14:46:00
 */
public class LevelOrderTraverse102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelVale = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                levelVale.add(cur.val);
                // 先left在right
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(levelVale);//一层遍历完后，记录这一层的值
        }
        return res;
    }

//----------------------------递归处理-----------------------------------

    public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(root,res,0);
        return res;
    }

    private void bfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (level >= res.size()) res.add(new ArrayList<>());//新的一层，初始化新的层级空数组
        res.get(level).add(root.val);//添加节点值,level控制添加到那个层级
        if (root.left != null) bfs(root.left,res,level+1);
        if (root.right != null) bfs(root.right,res,level+1);
    }


}
