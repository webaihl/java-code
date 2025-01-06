package org.example.code;

import java.util.HashSet;
import java.util.Set;

/** 数组中是否存在重复元素
 * @author web
 * @date 2022年07月14日
 */
public class DupNumInArr {



    public static void main(String[] args) {
        //1、存进set，比较长度
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 5, 5}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> bitSet = new HashSet<>();
        for (int num : nums) {
            if (bitSet.contains(num)) {
                return true;
            }
            bitSet.add(num);
        }
        return false;
    }

}
