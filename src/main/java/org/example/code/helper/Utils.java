package org.example.code.helper;

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

    private static TreeNode buildTree(Integer[] nodes, int index) {
        return index < nodes.length?
                new TreeNode(nodes[index],
                        buildTree(nodes,2*index+1),
                        buildTree(nodes,2*index+2)
                ):null;
    }
}
