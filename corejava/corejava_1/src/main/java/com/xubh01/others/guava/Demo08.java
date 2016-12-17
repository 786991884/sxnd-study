package com.xubh01.others.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

import java.util.Map;
import java.util.Set;

/**
 * 双键的Map -->Table -->rowKey+columnKey+value
 * 1、方法
 * 所有的行数据:cellSet()
 * 所有的学生: rowKeySet()
 * 所有的课程:columnKeySet()
 * 所有的成绩: values()
 * 学生对应的课程: rowMap() +get(学生)
 * row(学生)
 * 课程对应的学生: columnMap +get(课程)
 * column(课程)
 */
public class Demo08 {

    public static void main(String[] args) {
        Table<String, String, Integer> tables = HashBasedTable.create();
        //测试数据
        tables.put("a", "javase", 80);
        tables.put("b", "javase", 90);
        tables.put("a", "oracle", 100);
        tables.put("c", "oracle", 95);

        //所有的行数据
        Set<Cell<String, String, Integer>> cells = tables.cellSet();
        for (Cell<String, String, Integer> temp : cells) {
            System.out.println(temp.getRowKey() + "-->" + temp.getColumnKey() + "-->" + temp.getValue());
        }

        System.out.println("==========学生查看成绩==============");
        System.out.print("学生\t");
        //所有的课程
        Set<String> cours = tables.columnKeySet();
        for (String t : cours) {
            System.out.print(t + "\t");
        }
        System.out.println();
        //所有的学生
        Set<String> stus = tables.rowKeySet();
        for (String stu : stus) {
            System.out.print(stu + "\t");
            Map<String, Integer> scores = tables.row(stu);
            for (String c : cours) {
                System.out.print(scores.get(c) + "\t");
            }
            System.out.println();
        }

        System.out.println("==========课程查看成绩==============");
        System.out.print("课程\t");
        //所有的学生
        Set<String> stuSet = tables.rowKeySet();
        for (String t : stuSet) {
            System.out.print(t + "\t");
        }
        System.out.println();
        //所有的课程
        Set<String> courSet = tables.columnKeySet();
        for (String c : courSet) {
            System.out.print(c + "\t");
            Map<String, Integer> scores = tables.column(c);
            for (String s : stuSet) {
                System.out.print(scores.get(s) + "\t");
            }
            System.out.println();
        }
        System.out.println("===========转换===========");
        Table<String, String, Integer> tables2 = Tables.transpose(tables);
        //所有的行数据
        Set<Cell<String, String, Integer>> cells2 = tables2.cellSet();
        for (Cell<String, String, Integer> temp : cells2) {
            System.out.println(temp.getRowKey() + "-->" + temp.getColumnKey() + "-->" + temp.getValue());
        }

    }

}
