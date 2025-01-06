package org.example.code;

/**
 * 不在意顺序
 */
public class RmEleInSortedArray {


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int len = removeElement2(nums,2);
        System.out.println("length = "+len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+"\t");
        }
    }

    /** 拷贝覆盖
     * @param nums content
     * @param val will remove ele value 没有可删除元素时，也需要遍历整个数组
     * @return new length
     */
    public static int removeElement1(int[] nums, int val) {
        if (nums == null) { return 0; }
        int idx = 0;

        for (int x: nums){
            if (x != val){
                nums[idx++] = x;
            }
        }
        return idx;
    }

    /** 交换移除
     * @param nums content
     * @param val will remove ele value
     * @return new length
     */
    public static int removeElement2(int[] nums, int val) {
        if (nums == null) { return 0; }

        int left = 0, right = nums.length;
        while (left < right){
            if (nums[left] == val){
                nums[left] = nums[right-1];
                right--;
                // left++; 避免复制过来的右指针元素跟val也相等时，造成跳过
            }else {
                left++;
            }
        }

        return left;
    }
}
