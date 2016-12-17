package com.xubh02.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss,属于本月的第W周");
        Date d = new Date(12321314323L);
        String str = df.format(d);   //将时间对象按照格式化字符串，转化成字符串
        System.out.println(str);
        System.out.println("####################");
        String str2 = "1977-7-7";
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d2 = df2.parse(str2);
            System.out.println(d2);
            System.out.println(df2.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
