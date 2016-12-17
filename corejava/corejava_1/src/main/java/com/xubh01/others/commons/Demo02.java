package com.xubh01.others.commons;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 解耦，业务处理与判断进行分类
 * 函数式编程 Transformer 类型转化
 * 1、new Transformer() +transform
 * 2、SwitchTransformer
 * CollectionUtils.collect(容器,转换器)
 */
public class Demo02 {

    public static void main(String[] args) {
        System.out.println("===自定义类型转换==");
        //判别式
        Predicate<Employee> isLow = new Predicate<Employee>() {

            @Override
            public boolean evaluate(Employee emp) {
                return emp.getSalary() < 10000;
            }

        };
        Predicate<Employee> isHigh = new Predicate<Employee>() {

            @Override
            public boolean evaluate(Employee emp) {
                return emp.getSalary() >= 10000;
            }

        };
        Predicate[] pres = {isLow, isHigh};

        //转换
        Transformer<Employee, Level> lowTrans = new Transformer<Employee, Level>() {

            @Override
            public Level transform(Employee input) {
                return new Level(input.getName(), "卖身中");
            }
        };

        Transformer<Employee, Level> highTrans = new Transformer<Employee, Level>() {

            @Override
            public Level transform(Employee input) {
                return new Level(input.getName(), "养身中");
            }
        };
        Transformer[] trans = {lowTrans, highTrans};

        //二者进行了关联
        Transformer switchTrans = new SwitchTransformer(pres, trans, null);

        //容器
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("老马", 1000000));
        list.add(new Employee("老裴", 999));

        Collection<Level> levelList = CollectionUtils.collect(list, switchTrans);


        //遍历容器
        Iterator<Level> levelIt = levelList.iterator();
        while (levelIt.hasNext()) {
            System.out.println(levelIt.next());
        }

    }

    /**
     * 内置类型的转换
     */
    public static void inner() {
        System.out.println("===内置类型转换  长整形时间日期，转成指定格式的字符串==");
        //类型转换器
        Transformer<Long, String> trans = new Transformer<Long, String>() {

            @Override
            public String transform(Long input) {
                return new SimpleDateFormat("yyyy年MM月dd日").format(input);
            }
        };
        //容器
        List<Long> list = new ArrayList<Long>();
        list.add(999999999999L);
        list.add(300000000L);

        //工具类 程序猿出钱---开发商---农民工出力
        Collection<String> result = CollectionUtils.collect(list, trans);
        //遍历查看结果
        for (String time : result) {
            System.out.println(time);
        }
    }

}
