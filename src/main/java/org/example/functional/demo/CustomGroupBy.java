package org.example.functional.demo;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * @author web
 * @date 2022年04月27日
 */
public class CustomGroupBy {


    public static void main(String[] args) {
        Map<String, String> categorys = getCategory();
        Map<Integer, List<AppInfo>> collect = getAppInfos().stream().collect(groupingBy(appInfo -> {
            List<String> split = Arrays.asList(appInfo.getCategory().split(","));
            if (split.contains("1")) {
                return 1;
            }
            if (split.contains("2")) {
                return 2;
            }
            return 0;
        },mapping(Function.identity(),
                collectingAndThen(toList(),e->e.stream()
                        .sorted(Comparator.comparing(AppInfo::getCount)).collect(toList())))));

//        collect.entrySet().removeIf(e->e.getValue().size() == 0);
        System.out.println(collect);
        TreeMap<Integer, List<AppInfo>> treeMap = new TreeMap<>(collect);

        List<SearchResult> results = new ArrayList<>(treeMap.size());

        treeMap.forEach((k,v)->{
            results.add(new SearchResult(categorys.getOrDefault(String.valueOf(k),"pt"),v));
        });

        System.out.println(results);
    }


    public static List<AppInfo> getAppInfos() {
        List<AppInfo> appInfos = new ArrayList<>();
        appInfos.add(new AppInfo("a1", "1,7,9", 1));
        appInfos.add(new AppInfo("a1", "2,7,9", 2));
        appInfos.add(new AppInfo("a1", "3,7,9", 3));
        appInfos.add(new AppInfo("a1", "4,7,9", 4));
        appInfos.add(new AppInfo("a1", "5,7,9", 5));
        appInfos.add(new AppInfo("a1", "1,7,9", 2));
        appInfos.add(new AppInfo("a1", "2,7,9", 2));
        appInfos.add(new AppInfo("a1", "5,7,9", 8));
        appInfos.add(new AppInfo("a1", "5,7,9", 6));
        return appInfos;
    }


    public static Map<String, String> getCategory() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "yd");
        map.put("2", "qd");
        map.put("3", "zy");
        map.put("4", "win");
        map.put("5", "wy");
        return map;
    }
}
