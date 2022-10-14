package org.example.code.helper;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Utils {

    public static void printLinked(ListNode node){
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println();
    }


    public static ListNode list2Linked(Integer[] nodes){
        assert nodes.length > 0 :"array size must than 1";
        ListNode head = new ListNode(nodes[0]);
        ListNode body = head;
        for (int i=1;i<nodes.length;i++) {
            body.next = new ListNode(nodes[i]);
            body = body.next;
        }
        return head;
    }


    public static TreeNode buildTree(Integer[] nodes){

        return buildTree(nodes, 0);
    }

    //FIXME err when contain null item
    private static TreeNode buildTree(Integer[] nodes, int index) {
        return index < nodes.length?
                nodes[index] == null? null : new TreeNode(nodes[index],
                        buildTree(nodes,2*index+1),
                        buildTree(nodes,2*index+2)
                ) : null;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] arr, int i, int j) {
       j = Math.min(j, arr.length);
        for (int k = i; k < j - 1; k++) {
            System.out.print(arr[k]+ " ");
        }
        System.out.println();
    }

    public static void printArr(int[] arr, int i) {
        printArr(arr,i,arr.length);
    }

    public static void printArr(int[] arr) {
        printArr(arr,0,arr.length);
    }

    public static void printList(List<Integer> list) {
        list.forEach(System.out::print);
        System.out.println();
    }
}
