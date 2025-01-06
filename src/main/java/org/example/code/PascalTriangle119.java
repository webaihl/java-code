package org.example.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author web
 * @date 2022年06月14日
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex+1 行。
 */
public class PascalTriangle119 {

    /**
     * @param rowIndex 0 <= rowIndex <= 33
     * @return num th row
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);

        if (rowIndex >= 0) {
            res.add(1);
        }

        for (int i = 1; i < rowIndex + 1; i++) {
            res.add(1);//当前行比上一行多1
            for (int j = i - 1; j > 0; j--) { //从后往前
                res.set(j, res.get(j) + res.get(j - 1));//当前值=自身+前一个值
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle119().getRow(0));
    }
}
