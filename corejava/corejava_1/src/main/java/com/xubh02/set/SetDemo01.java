package com.xubh02.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 默认的hashcode时地址转换码，需要重写
 * 先比较hashcode
 * 再比较equals
 */
public class SetDemo01 {

    public static void main(String[] args) {
        Food food1 = new Food("瓜子", 5);
        Food food2 = new Food("糖果", 10);
        Food food3 = new Food("瓜子", 5);
        Food food4 = new Food("瓜子2", 5);
        Set<Food> set = new HashSet<Food>();
        set.add(food1);
        set.add(food1);
        set.add(food2);
        set.add(food3);
        set.add(food4);
        System.out.println(set.size());

        System.out.println("===foreach=====");
        for (Food temp : set) {
            System.out.println(temp.getPrice() + "-->" + temp.getName());
        }
        System.out.println("======iterator=========");
        Iterator<Food> it = set.iterator();
        while (it.hasNext()) { //判断，不会移动游标 |指针
            Food temp = it.next(); //一次移动一个游标 不能移动多次
            //System.out.println(it.next().getPrice()+"-->"+it.next().getName());
            System.out.println(temp.getPrice() + "-->" + temp.getName());
        }


    }

}
