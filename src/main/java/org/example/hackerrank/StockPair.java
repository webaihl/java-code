package org.example.hackerrank;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName StockPair.java
 * @Description 唯一的pair
 * @createTime 2022年10月12日 10:39:00
 */
public class StockPair {

    public static void main(String[] args) {
        StockPair stockPair = new StockPair();
        System.out.println(stockPair.getPairs(Lists.newArrayList(3,1, 2, 3, 4, 5), 6));
    }

    public int getPairs(List<Integer> stocksProfit, long target) {
        Collections.sort(stocksProfit);
        int j = stocksProfit.size() - 1;
        int res = 0;
        for (int i = 0; i < j; i++) {
            long ins = target - stocksProfit.get(i);
            if (ins < stocksProfit.get(i)) break;

            for (; i < j; j--) {
                if (ins > stocksProfit.get(j)) break;
                if (ins == stocksProfit.get(j)) {
                    res++;
                    j--;
                    break;
                }
            }
        }

        return res;
    }



}
