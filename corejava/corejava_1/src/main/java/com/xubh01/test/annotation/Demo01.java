package com.xubh01.test.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试内置注解用法
 */
public class Demo01  /*extends Object*/ {

    @Override
    public String toString() {
        return "";
    }

    @Deprecated
    public static void test001() {
        System.out.println("test001");
    }


    public static void test002() {
        List list = new ArrayList();
        List list2 = new ArrayList();

    }

    public static void main(String[] args) {
        Date d = new Date();
        test001();
    }


}



