package com.xubh01.others.three;

import java.util.EnumMap;

/**
 * EnumMap要求键为枚举
 */
public class EnumMapDemo {

    public static void main(String[] args) {
        EnumMap<Season, String> map = new EnumMap<Season, String>(Season.class);
        //存放值
        map.put(Season.SPRING, "春困");
        map.put(Season.SUMMER, "夏无力");
        map.put(Season.AUTUMN, "秋乏");
        map.put(Season.WINTER, "冬眠");

        System.out.println(map.size());

    }

}

//季节
enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}