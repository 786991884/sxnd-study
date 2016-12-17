package com.xubh01.sorm.utils;

import java.lang.reflect.Method;

/**
 * 封装了反射常用的操作
 */
public class ReflectUtils {

    /**
     * 调用obj对象对应属性fieldName的get方法
     *
     * @param fieldName
     * @param obj
     * @return
     */
    public static Object invokeGet(String fieldName, Object obj) {
        try {
            Class c = obj.getClass();
            Method m = c.getDeclaredMethod("get" + StringUtils.firstChar2UpperCase(fieldName), (Class<?>) null);
            return m.invoke(obj, (Object) null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void invokeSet(Object obj, String columnName, Object columnValue) {
        try {
            Method m = obj.getClass().getDeclaredMethod("set" + StringUtils.firstChar2UpperCase(columnName),
                    columnValue.getClass());
            m.invoke(obj, columnValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
