package com.xubh.java8.test2;

public class SubClass /*extends MyClass*/ implements MyFun, MyInterface {

    @Override
    public String getName() {
        return MyInterface.super.getName();
    }

}
