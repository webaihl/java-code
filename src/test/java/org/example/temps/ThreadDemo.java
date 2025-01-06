package org.example.temps;

import org.example.code.helper.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class ThreadDemo {

    static Thread a = null, b = null;

    /**
     * 两个二进制字符串相加
     */
    public void addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int ca = 0; //是否进位
        for (int i=a.length()-1,j=b.length()-1;i>=0 || j>=0;i--,j--){
            int sum = ca;
            sum += (i>=0? a.charAt(i) - '0':0);
            sum += (j>=0? b.charAt(j) - '0':0);
            res.append(sum % 2); // 如果二者都为1  那么sum%2应该刚好为0 否则为1
            ca = sum / 2; // 如果二者都为1  那么ca 应该刚好为1 否则为0
        }
        res.append(ca == 1? ca: "");//最后一位
        System.out.println(res.reverse().toString());
    }
    @Test
    public void OddEvenPrinter() {

        a = new Thread(()->{
            for (int i = 1; i <= 99; i+=2) {
                System.out.println(Thread.currentThread().getName() + "--"+i);
                LockSupport.unpark(b);
                LockSupport.park();
            }
        });

        b = new Thread(()->{
            for (int i = 1; i <= 100; i+=2) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + "--"+i);
                LockSupport.unpark(a);
            }
        });

        a.start();
        b.start();
    }

    public void twoTimesNum(int[] nums){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0){
                res.add(nums[i]);
            }else {
                nums[idx] = -1;
            }
        }
        System.out.println(res);
    }

    @Test
    public void testTwoTimesNum(){
        twoTimesNum(new int[]{1,1,2,2,3,3});
    }

    public void flipTwoNode(ListNode head){

    }

}
