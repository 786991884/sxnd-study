package com.xubh01.others.three;

import java.util.WeakHashMap;

/**
 * WeakHashMap 键为弱类型，gc运行立即回收
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        WeakHashMap<String, String> map = new WeakHashMap<String, String>();
        //测试数据
        //常量池对象，不会回收
        map.put("abc", "a");
        map.put("d", "test");
        //gc运行 已被回收
        map.put(new String("xubh02"), "c");
        map.put(new String("dsf"), "d");

        //通知回收
        System.gc();
        System.runFinalization();

        System.out.println(map.size());
    }

}
