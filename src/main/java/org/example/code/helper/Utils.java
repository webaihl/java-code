package org.example.code.helper;

public class Utils {

    public static void printLinked(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
    }
}
