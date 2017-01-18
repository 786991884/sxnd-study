package com.xubh.java8.test;

public class FilterEmployeeForAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee t) {
        return t.getAge() <= 35;
    }

}
