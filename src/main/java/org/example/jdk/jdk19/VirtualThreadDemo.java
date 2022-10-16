package org.example.jdk.jdk19;

import org.example.commom.SleepUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName VirtualThreadDemo.java
 * @Description 虚拟线程
 * @createTime 2022年10月09日 18:53:00
 */
public class VirtualThreadDemo {
    public static void main(String[] args) {
//        List<Integer> s = List.of(1,23);
//        s.remove(1);
//        Set.of(2,3,3);

//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(null,null);
//
//        Map<Integer, Integer> integerIntegerMap = Map.of(1, 1, 2, 2);
//        integerIntegerMap.put(1,1);
        Thread.startVirtualThread(()->{
            SleepUtil.delay(10);
        });
    }
}
