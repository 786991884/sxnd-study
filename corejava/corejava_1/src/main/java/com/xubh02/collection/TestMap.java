package com.xubh02.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map的基本用法
 */
public class TestMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("高琪", new Wife("张曼玉"));
        map.put("高琪", new Wife("张小玉"));
        map.put("张三", new Wife("杨幂"));

        Wife w = (Wife) map.get("高琪");

//		map.remove("高琪");

//		map.containsKey("张三");

        System.out.println(w.name);

    }

}

class Wife {
    String name;

    public Wife(String name) {
        this.name = name;
    }
}
