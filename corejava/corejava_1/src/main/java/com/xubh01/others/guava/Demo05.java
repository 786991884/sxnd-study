package com.xubh01.others.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Set;

/**
 * 统计单词出现的次数
 * 1、HashMap 分拣存储+面向对象思维  -->判断
 * 2、Multiset :无序+可重复   .count()  增强了可读性 +操作简单
 */
public class Demo05 {

    public static void main(String[] args) {
        String str = "this is a cat and that is a mice where is the food";
        //分割字符串
        String[] strArray = str.split(" ");
        //存储到Multiset中
        Multiset<String> set = HashMultiset.create();
        for (String strTemp : strArray) {
            set.add(strTemp);
        }

        //获取所有的单词 Set
        Set<String> letters = set.elementSet();
        for (String temp : letters) {
            System.out.println(temp + "-->" + set.count(temp));
        }


    }

}
