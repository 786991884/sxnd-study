package com.xubh.java8.test;

public class FilterEmployeeForSalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee t) {
        return t.getSalary() >= 5000;
    }

}