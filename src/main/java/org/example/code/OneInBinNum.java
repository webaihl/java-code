package org.example.code;

/**
 * @author web
 * @date 2022年08月23日
 */
public class OneInBinNum {

    public static void main(String[] args) {
        System.out.println(new OneInBinNum().getNum(4));
    }

    public int getNum(int n){
        int cnt = 0;
        while (n != 0){
            n &= (n-1);
            cnt++;
        }
        return cnt;
    }
}
