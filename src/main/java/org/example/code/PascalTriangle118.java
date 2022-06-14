package org.example.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author web
 * @date 2022年06月14日
 */
public class PascalTriangle118 {

    /**
     * @param numRows 1 <= numRows <= 30
     * @return each row
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);

        if (numRows >= 1) {
            res.add(Collections.singletonList(1));
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>(i);
            tmp.add(1);
            for (int j = 0; j < res.get(i - 1).size() - 1; j++) {
                tmp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j+1));
            }
            tmp.add(1);
            res.add(tmp);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle118().generate(3));
    }
}
