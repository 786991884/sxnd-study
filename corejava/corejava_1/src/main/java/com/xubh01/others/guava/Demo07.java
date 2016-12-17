package com.xubh01.others.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * HashMap 键唯一，值可以重复
 * BiMap:双向Map(Bidirectional Map ) 键与值都不能重复(unique -valued map)
 */
public class Demo07 {

    public static void main(String[] args) {
        BiMap<String, String> bimap = HashBiMap.create();
        bimap.put("xubh02", "xubh02@sina.com");
        bimap.put("good", "good@qq.com");
        //通过邮箱找用户
        String user = bimap.inverse().get("good@qq.com");
        System.out.println(user);
        System.out.println(bimap.inverse().inverse() == bimap);

    }

}
