package com.xubh02.col;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 添加元素 C
 * boolean add(E e)
 * 查看元素 R
 * size() 返回容器大小
 * contains(Object o) 判断是否存在元素 建议重写equals比较内容
 * isEmpty()  判断容器是否为空
 * 删除元素 D
 * remove(Object o) 删除指定的元素，建议自定义类型重写equals
 * clear()  清空容器
 * 其他方法:toArray()  toArray(T[] a)
 * <p>
 * 遍历:查看整个容器
 * foreach
 * iterator() 迭代器
 * 没有通过下标访问的for
 */
public class CollectionDemo01 {

    public static void main(String[] args) {
        //多态 :共性 看不到新增方法
        Collection<String> col = new ArrayList<String>();
        create(col);
        retrieve(col);
        delete(col);

        System.out.println(col.size());


        create(col);
        String[] arr = col.toArray(new String[0]);
        System.out.println(arr.length);
        System.out.println(arr[0]);
        iterCol(col);

    }

    /**
     * 遍历容器
     */
    public static void iterCol(Collection<String> col) {
        System.out.println("=========增强for foreach 不考虑下标======");
        for (String temp : col) {
            System.out.println(temp);
        }
        System.out.println("=========迭代器======");
        Iterator<String> it = col.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            System.out.println(temp);
        }
    }


    /**
     * 删除
     * 1、remove(对象)
     * 2、clear() 清空容器
     *
     * @param col
     */
    public static void delete(Collection<String> col) {
        boolean flag = col.remove("日本");
        System.out.println(flag);
        col.clear();
    }

    /**
     * 查看
     * 1、大小
     * 2、查看
     * 3、是否为空
     *
     * @param col
     */
    public static void retrieve(Collection<String> col) {
        System.out.println("容器的大小:" + col.size());
        System.out.println("查看" + col.contains("美国"));
        System.out.println("容器是否存在元素" + col.isEmpty());
    }

    /**
     * 添加元素
     * 1、在容器最后添加
     *
     * @param col
     */
    public static void create(Collection<String> col) {
        col.add("美国");
        col.add("中国");

    }

}
