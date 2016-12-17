package com.xubh02.col;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 添加若干个员工，求出员工的总工资，平均工资
 */
public class CollectionDemo02 {

    public static void main(String[] args) {
        Collection<Employee> co = new ArrayList<Employee>();
        Employee ee = new Employee("老马", 199999);
        co.add(ee);
        co.add(ee);
        co.add(new Employee("老高", 99999));
        co.add(new Employee("老裴", 1099999));

        //遍历
        Iterator<Employee> it = co.iterator();
        double total = 0.0;
        while (it.hasNext()) {
            Employee temp = it.next();
            total += temp.getSalary();
        }
        int size = co.size();
        System.out.println(size);
        System.out.println("总工资为:" + total + ",平均薪水" + total / size);

    }

}
