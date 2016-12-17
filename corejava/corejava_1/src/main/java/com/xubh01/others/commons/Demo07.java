package com.xubh01.others.commons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

/**
 * 双向Map 要求键与值都不能重复
 * BidiMap  inverseBidiMap()
 * 1、DualTreeBidiMap :有序
 * 2、DualHashBidiMap :无序
 */
public class Demo07 {

    public static void main(String[] args) {
        //hashMap();
        treeMap();
    }

    /**
     * 有序的双向Map
     */
    public static void treeMap() {
        System.out.println("=====有序的双向Map====");
        BidiMap<String, String> map = new DualTreeBidiMap<String, String>();
        map.put("bj", "bj@test.com");
        map.put("sxt", "sxt@qq.com");
        //遍历查看
        MapIterator<String, String> it = map.inverseBidiMap().mapIterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = it.getValue();
            System.out.println(key + "-->" + value);
        }
    }

    /**
     * 无序的双向Map
     */
    public static void hashMap() {
        System.out.println("=====无序的双向Map====");
        BidiMap<String, String> map = new DualHashBidiMap<String, String>();
        map.put("bj", "bj@test.com");
        map.put("sxt", "sxt@qq.com");
        //反转
        System.out.println(map.inverseBidiMap().get("sxt@qq.com"));
        //遍历查看
        MapIterator<String, String> it = map.inverseBidiMap().mapIterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = it.getValue();
            System.out.println(key + "-->" + value);
        }
    }

}
