package org.example.code.tree;

import org.example.code.helper.TreeNode;
import org.example.code.helper.Utils;

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
        System.out.println("-----------中-4251637-------------");
        traverse.middleTraverse(treeNode);
        System.out.println("-----------后-4526731-------------");
        traverse.postTraverse(treeNode);
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
}
