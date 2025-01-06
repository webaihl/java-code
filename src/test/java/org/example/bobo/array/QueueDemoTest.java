package org.example.bobo.array;

import cn.hutool.core.lang.Pair;
import org.example.code.helper.TreeNode;
import org.example.code.helper.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName QueueDemoTest.java
 * @Description queue
 * @createTime 2023年09月10日 20:11:00
 */
public class QueueDemoTest {
    //todo 102 107 103 109
    @Test
    public void binaryTreeLevelOrderTraversal_102() {
        TreeNode root = Utils.buildTree(new Integer[]{3,9,20,null,null,15,7});
        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(Pair.of(root, 0));
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> cur = q.poll();
            TreeNode node = cur.getKey();
            Integer level = cur.getValue();
            if (level == res.size()) { // 新增一层
                res.add(new ArrayList<>());
            }

            res.get(level).add(cur.getKey().val);
            if (node.left != null) {
                q.add(Pair.of(node.left, level + 1));
            }

            if (node.right != null) {
                q.add(Pair.of(node.right, level + 1));
            }
        }
        System.out.println(res);
    }

}
