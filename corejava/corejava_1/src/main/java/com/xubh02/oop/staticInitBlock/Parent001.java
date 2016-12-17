package com.xubh02.oop.staticInitBlock;

public class Parent001 /*extends Object*/ {
    static int aa;

    static {
        System.out.println(" 静态初始化Parent001");
        aa = 200;
    }
}
