package com.xubh01.others.que;

//测试自定义堆栈
public class Demo02 {

    public static void main(String[] args) {
        MyStack<String> backHistory = new MyStack<String>(3);
        backHistory.push("www.baidu.com");
        backHistory.push("www.google.com");
        backHistory.push("www.sina.com");
        backHistory.push("www.xubh02.cn");

        System.out.println("大小：" + backHistory.size());

        //遍历
        String item = null;
        while (null != (item = backHistory.pop())) {
            System.out.println(item);
        }
    }

}
