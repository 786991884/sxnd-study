package com.xubh01.test.annotation;


/**
 * 测试自定义注解的使用
 */
@SxtAnnotation01
public class Demo02 {

    @SxtAnnotation01(age = 19, studentName = "老高", id = 1001, schools = {"北京大学", "北京航空航天大学"})
    public void test() {
    }

    @SxtAnnotation02("aaaa")
    public void test2() {
    }

}