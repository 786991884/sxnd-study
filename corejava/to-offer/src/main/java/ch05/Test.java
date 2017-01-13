package ch05;

import ch01.MyArray;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        // 构建链表
        Date date1 = new Date();
        LinkList linkList = new LinkList();
        for (int i = 0; i < 1000000; i++) {
            linkList.insert(i);
        }
        Date date2 = new Date();
        System.out.println(date2.getTime() - date1.getTime());


        // 构建顺序表
        date1 = new Date();
        MyArray ma = new MyArray(1000000 + 1);
        for (int i = 0; i < 1000000; i++) {
            ma.insert(i);
        }
        date2 = new Date();
        System.out.println(date2.getTime() - date1.getTime());

        date1 = new Date();
        linkList.delete(888888);
        date2 = new Date();
        System.out.println(date2.getTime() - date1.getTime());

        date1 = new Date();
        ma.delete(888888);
        date2 = new Date();
        System.out.println(date2.getTime() - date1.getTime());


    }

}
