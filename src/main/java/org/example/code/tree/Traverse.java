package org.example.code.tree;

import org.example.code.helper.TreeNode;
import org.example.code.helper.Utils;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author web
 * @date 2022年08月10日
 */
public class Traverse {

    public static void main(String[] args) {
        Traverse traverse = new Traverse();
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7};
        TreeNode treeNode = Utils.buildTree(arr);
        System.out.println("-----------前-1245367-------------");
        traverse.preTraverse(treeNode);
        System.out.println("-----------前loop-1245367-------------");
        traverse.preTraverse_loop(treeNode);
        System.out.println("-----------中-4251637-------------");
        traverse.middleTraverse(treeNode);
        System.out.println("-----------后-4526731-------------");
        traverse.postTraverse(treeNode);
        System.out.println("-----------层级-1234567-------------");
        traverse.levelTraverse(treeNode);
    }
    public void preTraverse(TreeNode root){

        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preTraverse(root.left);
        preTraverse(root.right);
    }
    public void middleTraverse(TreeNode root){
        if (root == null) {
            return;
        }
        middleTraverse(root.left);
        System.out.print(root.val);
        middleTraverse(root.right);
    }

    public void postTraverse(TreeNode root){
        if (root == null) {
            return;
        }
        postTraverse(root.left);
        postTraverse(root.right);
        System.out.print(root.val);
    }

    public void preTraverse_loop(TreeNode root){
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(root);
        while (!arrayDeque.isEmpty()){
            TreeNode node = arrayDeque.pop();
            System.out.print(node.val);
            if (node.right != null){
                arrayDeque.addFirst(node.right);
            }
            if (node.left != null){
                arrayDeque.addFirst(node.left);
            }
        }
    }

    public void levelTraverse(TreeNode root){
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            System.out.print(curNode.val);
            if(curNode.left != null){
                queue.add(curNode.left);
            }
            if(curNode.right != null){
                queue.add(curNode.right);
            }
        }
    }
}
