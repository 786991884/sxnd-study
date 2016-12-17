package com.xubh01.others.en;

import java.util.StringTokenizer;

/**
 * Enumeration 子类
 * StringTokenizer:String split() 字符串分割
 * 不支持正则表达式
 * <p>
 * StringTokenizer(String str, String delim)
 */
public class Demo02 {

    public static void main(String[] args) {
        String emailStr = "xubh02@163.com;xubh02@qq.com;xubh02@sohu.com";
        StringTokenizer token = new StringTokenizer(emailStr, ";");
        //遍历获取
        while (token.hasMoreElements()) {
            System.out.println(token.nextElement());
        }
    }

}
