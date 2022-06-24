package org.example.commom;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author web
 * @date 2022年06月24日
 */
public class LevelUtils {


    /**
     * 层级结构转换
     *
     * @param data            层级数据
     * @param getIdFunc       获取id的方法
     * @param getPidFunc      获取父id的方法
     * @param getChildrenFunc 获取子集合的方法
     * @param setChildrenFunc 如果子集合为空，set子集合的方法
     * @return java.util.List<T>
     */
    public static <T, U> List<T> convert(List<T> data,
                                         Function<T, U> getIdFunc,
                                         Function<T, U> getPidFunc,
                                         Function<T, List<T>> getChildrenFunc,
                                         BiConsumer<T, List<T>> setChildrenFunc) {
        if (data == null) {
            return null;
        }
        Map<U, T> mapper = data.stream().collect(Collectors.toMap(getIdFunc, Function.identity()));

        List<T> result = new ArrayList<>();
        for (T element : data) {
            T parent = mapper.get(getPidFunc.apply(element));

            if (parent == null) {
                result.add(element);
                continue;
            }

            if (getChildrenFunc.apply(parent) == null) {
                setChildrenFunc.accept(parent, new ArrayList<>());
            }
            getChildrenFunc.apply(parent).add(element);
        }

        return result;
    }

    public static void main(String[] args) {
        @AllArgsConstructor
        @Data
        class Menu {
            private Integer id;
            private Integer pid;
            private String name;
            private List<Menu> children;
        }

        List<Menu> records = new ArrayList<>();
        records.add(new Menu(1, 0, "第一章", null));
        records.add(new Menu(2, 0, "第二章", null));
        records.add(new Menu(3, 0, "第三章", null));
        records.add(new Menu(21, 2, "第二章-第一节", null));
        records.add(new Menu(211, 21, "第二章-第一节-第一段", null));

        List<Menu> result = LevelUtils.convert(records, Menu::getId, Menu::getPid, Menu::getChildren, Menu::setChildren);
        System.out.println(result);
    }
}

