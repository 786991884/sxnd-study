package com.xubh02.col;

import java.util.Iterator;

/**
 * 简化迭代器原理 加入接口 提供方法
 * hasNext
 * next
 */
public class MyArrayList3 implements java.lang.Iterable<String> {
    private String[] elem = {"a", "b", "c", "d", "e", "f", "g"};
    private int size = elem.length;


    /**
     * 匿名内部类
     *
     * @return
     */
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int cursor = -1;

            /**
             * 判断是否存在下一个元素
             * @return
             */
            public boolean hasNext() {
                return cursor + 1 < size;
            }

            /**
             * 获取下一个元素
             */
            public String next() {
                cursor++; //移动一次
                return elem[cursor];
            }

            /**
             * 删除元素
             */
            public void remove() {
                //没有实现
            }

        };
    }


    public static void main(String[] args) {
        MyArrayList3 list = new MyArrayList3();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            it.remove(); //删除元素
        }


        it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("增强for，必须实现java.lang.Iterable接口，重写iterator方法");
        for (String temp : list) {
            System.out.println(temp);

        }


    }

}
