package com.xubh02.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 一、添加
 * add(int index, E element)  指定位置添加对象
 * 二、查看
 * get(int index) 指定位置获取元素
 * 三、修改|覆盖元素
 * set(int , E) 指定位置覆盖
 * 四、删除
 * remove(int index) 指定位置删除
 * 五、遍历
 * 1、for
 * 2、listIterator
 */
public class ListDemo01 {

    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<Fruit>();
        create(list);
        System.out.println(list.size());
        retrieve(list);
        update(list);
        delete(list);

        list.clear();
        create(list);
        iterCol(list);
    }

    /**
     * 遍历容器
     */
    public static void iterCol(List<Fruit> list) {
        System.out.println("=========增强for foreach 不考虑下标======");
        for (Fruit temp : list) {
            System.out.println(temp);
        }
        System.out.println("=========迭代器======");
        Iterator<Fruit> it = list.iterator();
        while (it.hasNext()) {
            Fruit temp = it.next();
            System.out.println(temp);
        }

        System.out.println("========普通for +get+size=======");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println("下标为:" + i + ",内容为:" + list.get(i));
        }

        System.out.println("========listiterator=======");
        ListIterator<Fruit> it2 = list.listIterator();
        //正向输出
        while (it2.hasNext()) { //判断，不会移动
            it2.next();
        }
        System.out.println("倒叙输出");
        while (it2.hasPrevious()) {
            System.out.println(it2.previous());
        }


    }


    /**
     * 修改元素
     *
     * @param list
     */
    public static void update(List<Fruit> list) {
        System.out.println("before==>" + list.get(1));
        list.set(4, new Fruit());
        System.out.println("after==>" + list.get(1));

    }


    /**
     * 删除
     * 1、remove(对象)
     * 2、clear() 清空容器
     * 3、remove(指定索引)
     *
     * @param list
     */
    public static void delete(List<Fruit> list) {
        boolean flag = list.remove(new Fruit(5, 6));
        System.out.println(flag);
        Fruit f1 = list.remove(0);
        System.out.println(f1);


    }

    /**
     * 查看
     * 1、大小
     * 2、查看
     * 3、是否为空
     * 4、
     *
     * @param list
     */
    public static void retrieve(List<Fruit> list) {
        System.out.println("容器的大小:" + list.size());
        System.out.println("查看" + list.contains(new Fruit(2, 20)));
        System.out.println("容器是否存在元素" + list.isEmpty());

        Fruit fruit = list.get(0); //指定位置查看
        System.out.println(fruit);
    }


    /**
     * 添加元素
     * 1、在容器最后添加
     * 2、在容器指定位置添加元素
     *
     * @param col
     */
    public static void create(List<Fruit> col) {
        col.add(new Fruit(1, 20));
        col.add(new Fruit(2, 20));
        col.add(0, new Fruit(3, 20)); // 插入元素
        col.add(3, new Fruit(4, 20));
        //col.add(5,new Fruit(1,20)); //错误，数组越界
        col.add(4, new Fruit(5, 20));
    }

}
