package com.xubh02.test;

import java.util.Date;

/**
 * 测试Date类的用法
 */
public class TestDate {
    public static void main(String[] args) {
        Date d = new Date();
        long t = System.currentTimeMillis();
        System.out.println(t);
        Date d2 = new Date(1000);

        //System.out.println(d2.toGMTString());   //不建议使用
        d2.setTime(24324324);
        System.out.println(d2.getTime());
        System.out.println(d.getTime() < d2.getTime());


    }
}
