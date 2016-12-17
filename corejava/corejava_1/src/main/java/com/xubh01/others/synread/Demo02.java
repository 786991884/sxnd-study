package com.xubh01.others.synread;

import java.util.*;

/**
 * 只读设置
 * emptyXxx()  空的不可变的集合
 * 1、emptyList()
 * emptyMap()
 * emptySet()
 * 2、singletonXxx() 一个元素不可变的集合
 * singleton(T o)
 * singletonList(T o)
 * singletonMap(K key, V value)
 * <p>
 * 3、unmodifiableXxx() 不可变容器
 * unmodifiableList(List<? extends T> list)
 * unmodifiableSet(Set<? extends T> s)
 * unmodifiableMap(Map<? extends K,? extends V> m)
 */
public class Demo02 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("test", "test");
        map.put("xubh02", "xubh02");

        //只读控制
        Map<String, String> map2 = Collections.unmodifiableMap(map);
        //map2.put("a", "a"); //不能操作
        System.out.println(map2.size());

        //一个元素的容器测试
        List<String> list = Collections.singletonList(new String());
        list.add("test");
        //list.add("xubh02"); //只能包含一个元素的容器
    }

    public static Set<String> oper(Set<String> set) {
        if (null == set) {
            return Collections.EMPTY_SET; //外部获取避免NullPointerException
        }
        //操作
        return set;
    }

}
