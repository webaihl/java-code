package org.example.code;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/** 个数大于 n/2 的元素，肯定存在
 * @author web
 * @date 2022年07月04日
 */
public class MostNumInArr {

    public static void main(String[] args) {
        System.out.println(find1(new int[]{1, 1, 1, 34, 2}));
        System.out.println(find1(new int[]{2, 2, 2, 1, 2}));
        System.out.println(find1(new int[]{2, 2, 2}));
        System.out.println(find1(new int[]{2}));
    }
    public static int find(int[] arr){
        int upLimit = arr.length / 2;
        return 0;
    }

    public static int find1(int[] arr){
      return Math.toIntExact(Arrays.stream(arr)
              .boxed()
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
              .entrySet().stream().max((a, b) -> (int) (a.getValue() - b.getValue())).get().getKey());
    }
}
