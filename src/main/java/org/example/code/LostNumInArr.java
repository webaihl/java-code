package org.example.code;

/** 长度n中缺失的数字，数字独一无二 268
 * @author web
 * @date 2022年07月12日
 */
public class LostNumInArr {

    public static void main(String[] args) {
        System.out.println(find(new int[]{0,2,3,5,4}));
        System.out.println(find2(new int[]{0,2,3,5,4}));
        System.out.println(find2(new int[]{0,1}));
    }

    public static int find(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + (i+1) - nums[i];
        }
        return sum;
    }

    public static int find2(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (i+1) ^ nums[i];
        }
        return sum;
    }

}
