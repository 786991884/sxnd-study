package com.xubh01.reflect;

import com.xubh01.server.demo3.Servlet;

/**
 * 创建实例  调用空构造
 */
public class Demo02 {

    /**
     * @param args
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clz = Class.forName("com.xubh02.server.demo03.LoginServlet");
        // 调用空构造 确保空构造存在
        Servlet ser = (Servlet) clz.newInstance();
        //retrun ser;
    }

}
