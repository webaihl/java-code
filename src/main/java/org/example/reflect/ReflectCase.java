package org.example.reflect;

import org.example.commom.User;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author web
 * @date 2022年08月11日
 */
public class ReflectCase {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(10);
        user.setName("web");
        System.out.println(getFieldAndValue(User.class,user));
    }

    public static Map<String, Object> getFieldAndValue(Class<?> targetClass, Object obj) {

        Field[] fields = targetClass.getDeclaredFields();
        Map<String, Object> maps = new HashMap<>(fields.length);
        try {
            for (Field f : fields) {
                Field privateField = targetClass.getDeclaredField(f.getName());
                privateField.setAccessible(true);
                Object value = privateField.get(obj);
                maps.put(f.getName(), value);
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        return maps;
    }
}
