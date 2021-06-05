package com.zzspace.blog.common.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 76973 on 2021/6/5 9:06
 */
public class ConvertUtils {
    /**
     *  将DTO相互DO 前提: DTO与DO对应的属性名相同
     * @param object DTO 对象
     * @param tClass 目标DO对象
     */
    public static <T> T convert(Object object, Class<T> tClass) {
        Map<String, Field> name2Filed = new HashMap<>();
        Class<?> sClass = object.getClass();
        try {
            T target = tClass.newInstance();
            Field[] targetField = tClass.getDeclaredFields();
            for (Field field : targetField) {
                field.setAccessible(true);
                name2Filed.put(field.getName(), field);
            }
            Field[] sourceField = sClass.getDeclaredFields();
            for (Field field : sourceField) {
                field.setAccessible(true);
                String name = field.getName();
                if (name2Filed.containsKey(name)) {
                    Field matched = name2Filed.get(name);
                    Object value = field.get(object);
                    if (value != null) {
                        matched.set(target, value);
                    }
                }
            }
            return target;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
