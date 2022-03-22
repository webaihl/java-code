package org.example.jdk8.lambda;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 计算字符串中每个字符出现的数量
 */
public class CharacterCount {

    public static void main(String[] args) {

        String str = "abafeafe jf hal fhi oaei iohapgr hrgjnsgja ihg nusabug aghoparkjtgk ofjs kgjdksa;fnvrei";
        //String tmp = str.replaceAll("[^A-Za-z\\s]", "").toLowerCase();
        Map<String, Long> collect = Arrays.stream(str.split(""))
                .collect((Collectors.groupingBy(Function.identity(), Collectors.counting())));

        System.out.println(collect);
    }

}
