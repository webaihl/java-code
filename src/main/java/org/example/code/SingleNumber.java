package org.example.code;

/**
 * @author web
 * @date 2022年05月27日
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 3, 3, 5, 5, 7, 8, 7,1}));
    }

    /**
     * 其余恰出现2个
     * @param nums 数组
     * @return 结果
     */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    /**
     *  其余恰出现3个
     * @param nums 数组
     * @return 结果
     */
    public static int singleNumber3(int[] nums) {
        //todo
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
