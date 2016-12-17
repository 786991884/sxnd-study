package com.xubh02.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试List中的基本方法
 */
public class Test01 {

    public static void main(String[] args) {
        List list = new ArrayList();
        //ArrayList:底层实现时数组,线程不安全，效率高。所以，查询快。修改、插入、删除慢。
        //LinkedList:底层实现是链表,线程不安全，效率高。所以，查询慢。修改、插入、删除快。
        //Vector:线程安全的，效率低。

        list.add("aaa");
        list.add("aaa");
        list.add(new Date());
        list.add(new Dog());
        list.add(1234);  //包装类的：自动装箱！
        list.remove(new String("aaa"));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.set(3, new String("3333"));
        list.add(4, new String("3333"));
/*		System.out.println(list.isEmpty());
        list.remove(new Dog());      //hashcode和equals
		System.out.println(list.size());

		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");

		list.add(list2);

		//跟顺序的操作
		String str = (String) list.get(0);
		System.out.println(str); 
		list.set(1, "ababa");
		list.remove(0);*/

    }
    static class Dog {

    }
}