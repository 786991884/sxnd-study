package com.xubh02.col;

/**
 * 简化迭代器原理
 * hasNext
 * next
 */
public class MyArrayList {
    private String[] elem = {"a", "b", "c", "d", "e", "f", "g"};
    private int size = elem.length;


    private int cursor = -1;

    /**
     * 判断是否存在下一个元素
     *
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

    }


    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        while (list.hasNext()) {
            System.out.println(list.next());
        }

        list = new MyArrayList();
        while (list.hasNext()) {
            System.out.println(list.next());
        }
    }

}
