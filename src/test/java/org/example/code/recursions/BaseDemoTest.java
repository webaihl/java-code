package org.example.code.recursions;

import org.example.code.helper.ListNode;
import org.example.code.helper.Utils;
import org.example.commom.SleepUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BaseDemoTest.java
 * @Description
 * @createTime 2023年02月09日 14:26:00
 */
class BaseDemoTest {

    BaseDemo baseDemo;

    @BeforeEach
    public void setUp() {
        baseDemo = new BaseDemo();
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void fibonacci() {
        assertEquals(1, baseDemo.fibonacci(1));
        assertEquals(2, baseDemo.fibonacci(3));
        assertEquals(5, baseDemo.fibonacci(5));
    }

    @Test
    void printRevers() {
        ListNode root = Utils.list2Linked(new Integer[]{1, 2, 3, 4, 5});
        baseDemo.printRevers(root);
    }

    @Test
    void combinationSum() {
        baseDemo.combinationSum(new ArrayList<>(), new int[]{1, 2, 3, 4, 5}, 4);
    }

    @Test
    void binary() {
        baseDemo.binary(new int[]{0, 0}, 0);
    }


    @Test
    void plusOrder() {
        int a = 1, b = 3, c = (a + b > 3 ? ++a : b++);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    @Test
    void recursiveDemo() {
        baseDemo.recursiveDemo(2);
    }

    @Test
    void combinationSum3() {
        baseDemo.combinationSum3(7,3);
    }

    @Test
    void subsets() {
        baseDemo.subsets(new int[]{1,2,3});
    }
}