package com.xubh01.gen04;

/**
 * 通配符
 * ?类型不定，使用时确定类型
 * ?使用:声明类型|声明方法上，不能声明类或使用时
 * ? extends : <= 上限  指定类型 子类或自身
 * ? super :>=下限   指定类型 为自身或父类
 */
public class Student<T> {
    T score;


    public static void main(String[] args) {
        Student<?> stu = new Student<String>();
        test(new Student<Integer>());

        test2(new Student<Apple>());
        //test3(new Student<Apple>()); //泛型没有多态

        //test4(new Student<Apple>()); //<
        stu = new Student<Fruit>();
        ;
        //test4(stu); //使用时确定类型
        test4(new Student<Object>());
        test4(new Student<Fruit>());

    }

    public static void test(Student<?> stu) {

    }

    public static void test3(Student<Fruit> stu) {

    }

    // <=
    public static void test2(Student<? extends Fruit> stu) {

    }

    //>=
    public static void test4(Student<? super Fruit> stu) {

    }

}
