package com.xubh02.iterator;

import java.util.*;

public class Test01 {


    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        //通过索引遍历List
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //通过迭代器遍历List
        for (Iterator iter2 = list.iterator(); iter2.hasNext(); ) {
            String str = (String) iter2.next();
            System.out.println(str);
            iter2.remove();
            iter2.remove();
        }

        System.out.println(list.size() + "******");

        Set set = new HashSet();
        set.add("高1");
        set.add("高2");
        set.add("高3");

        //通过迭代器遍历Set
//		Iterator iter = set.iterator();
//		while(iter.hasNext()){
        for (Iterator iter = set.iterator(); iter.hasNext(); ) {
            String str = (String) iter.next();
            System.out.println(str);
        }

    }

}
