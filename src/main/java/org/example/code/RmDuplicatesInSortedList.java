package org.example.code;

public class RmDuplicatesInSortedList {


    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        System.out.println("length = "+len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+"\t");
        }
    }

    /**
     * @param nums content
     * @return new length
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int p = 0, q = 1;
        while (q < nums.length){
            if (nums[p] != nums[q] && p != q){
                nums[p+1] = nums[q];
                p++;
            }
            q++;
        }
        return p+1;
    }
}
