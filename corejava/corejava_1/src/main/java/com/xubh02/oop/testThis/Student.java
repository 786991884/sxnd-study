package com.xubh02.oop.testThis;

public class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this(name);   //通过this调用其他构造方法，必须位于第一句！ Constructor call must be the first statement in a constructor
        this.name = name;
        this.id = id;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student() {
        System.out.println("构造一个对象");
    }

    public void setName(String name) {
        this.name = name;
    }


    public void study() {
        this.name = "张三";
        System.out.println(name + "在學習");
    }

    public void sayHello(String sname) {
        System.out.println(name + "向" + sname + "說：你好！");
    }

}



