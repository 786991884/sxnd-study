package com.xubh01.others.en;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration 的使用
 * 1、判断  hasMoreElements()
 * 2、获取 nextElement()
 * <p>
 * Vector 的 elements()方法
 */
public class Demo01 {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<String>();
        vector.add("javase");
        vector.add("html");
        vector.add("oracle");

        //遍历该Vector
        Enumeration<String> en = vector.elements();
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }


    }

}
