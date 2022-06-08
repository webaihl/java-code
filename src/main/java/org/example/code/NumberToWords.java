package org.example.code;

import java.util.ArrayList;

/**
 * @author web
 * @date 2022年06月08日
 */
public class NumberToWords {
    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        String sNum = String.valueOf(num);
        int len = sNum.length();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i<Math.floor(len / 3) ;i++){
            nums.add(Integer.parseInt(sNum.substring(len-(i+1)*3, len-i*3)));
        }
        if (len % 3 != 0) {
            nums.add(Integer.parseInt(sNum.substring(0,len%3)));
        }
        String[] ztNum = { "", "One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten" };
        String[] teeNum = { "",  "Eleven", "Twelve","Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
        String[] oNum = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety", "Hundred" };
        String[] bigNum = { "","Thousand", "Million", "Billion" };
        int[] tempInt = new int[3];
        for(int j=nums.size()-1;j>=0;j--){
            int t = 0;
            int tempNum = nums.get(j);
            int beforeNum = nums.get(j);
            while (tempNum != 0) {
                tempInt[2 - (t++)] = tempNum % 10;
                tempNum /= 10;
            }
            if (beforeNum > 99) {
                sb.append(ztNum[tempInt[0]]).append(" ").append(oNum[oNum.length - 1]).append(" ");
                int temp = tempInt[1]*10+tempInt[2];
                if (temp>10 &&temp <20) {
                    sb.append(teeNum[tempInt[2]]).append(" ");
                }else {
                    sb.append(oNum[tempInt[1]]).append(" ").append(ztNum[tempInt[2]]).append(" ");
                }
            } else if (beforeNum > 10) {
                if (beforeNum % 10 == 0) {
                    sb.append(oNum[tempInt[1]]);
                } else if (beforeNum < 20) {
                    sb.append(teeNum[tempInt[2]]).append(" ");
                } else {
                    sb.append(oNum[tempInt[1]]).append(" ").append(ztNum[tempInt[2]]).append(" ");
                }
            } else if (beforeNum >0) {
                sb.append(ztNum[beforeNum]).append(" ");
            }else if (num == 0) {
                sb.append("Zero");
            }
            if(beforeNum != 0)
                sb.append(" ").append(bigNum[j]).append(" ");

        }
        return (sb.toString().trim().replaceAll(" +", " "));

    }

}
