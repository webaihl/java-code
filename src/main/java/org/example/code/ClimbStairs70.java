package org.example.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author web
 * @date 2022年06月08日
 */
public class ClimbStairs70 {

    private final Map<Integer, Integer> maps = new HashMap<>();
    public int climbStairs(int n) {

        if (n < 1){
            return 0;
        }

        if(n == 1 || n == 2){
            return n;
        }

        if (maps.containsKey(n)){
            return maps.get(n);
        }
        int  res = climbStairs(n-1) + climbStairs(n-2);
        maps.put(n,res);
        return  res;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs70().climbStairs(2));
        System.out.println(new ClimbStairs70().climbStairs(3));
        System.out.println(new ClimbStairs70().climbStairs(4));
    }
}
