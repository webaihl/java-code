package org.example.code;

/**
 * @author web
 * @date 2022年06月21日
 * mod后的数字，如何累乘
 */

public class EvertNum {

    public static void main(String[] args) {
        System.out.println(new EvertNum().evert(0));
        System.out.println(new EvertNum().evert(1234567));
        System.out.println(new EvertNum().evert(7654321));
        System.out.println(new EvertNum().evert(100));
    }

    public int evert(int n){
        int remainder = 0,reversionNum = 0;
        while (n > 0){
            remainder = n % 10;
            reversionNum = reversionNum * 10 + remainder;
            n /= 10;
        }
        return reversionNum;
    }
}
