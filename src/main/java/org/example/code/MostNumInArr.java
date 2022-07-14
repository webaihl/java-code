package org.example.code;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/** 个数大于 n/2 的元素，肯定存在
 * @author web
 * @date 2022年07月04日
 */
public class MostNumInArr {

    public static void main(String[] args) {
//        System.out.println(find2(new int[]{1, 1, 1, 34, 2}));
//        System.out.println(find2(new int[]{2, 2, 2, 1, 2}));
//        System.out.println(find2(new int[]{2, 2, 2}));
//        System.out.println(find2(new int[]{2}));
        System.out.println(find2(new int[]{8,8,7,7,7}));
        System.out.println(find2(new int[]{3,2,3}));
    }

    public static int find1(int[] arr) {
        return Math.toIntExact(Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max((a, b) -> (int) (a.getValue() - b.getValue()))
                .get().getKey());
    }

    public static int find2(int[] nums) {
        int upLimit = nums.length / 2;
        int maxItem = nums[0], maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (maxItem == nums[i]){
                maxCount++;
                if(maxCount > upLimit){
                    return maxItem;
                }
                continue;
            }
            maxCount--;
            if (maxCount == 0){
                //当前值已经消耗对方1 ，只接下一个
                maxItem = nums[i+1];
            }
        }
        return maxItem;
    }
}