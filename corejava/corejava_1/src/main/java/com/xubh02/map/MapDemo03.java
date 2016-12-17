package com.xubh02.map;

import java.util.*;

/**
 * 定义一个Student类,属性:name 姓名,classNumber 班号,score 成绩
 * 现在将若干Student对象放入List,请统计出每个班级的总分和平均分,分别打印出来
 * 以面向对象的思维解决
 */
public class MapDemo03 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        exam(list);

        //统计
        Map<String, ClassRoom> rooms = new HashMap<String, ClassRoom>();
        count(rooms, list);
        //打印
        printScore(rooms);
    }

    /**
     * 打印 总分与平均分
     */
    public static void printScore(Map<String, ClassRoom> rooms) {
        Set<Map.Entry<String, ClassRoom>> entrySet = rooms.entrySet();
        Iterator<Map.Entry<String, ClassRoom>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, ClassRoom> entry = it.next();
            ClassRoom room = entry.getValue();
            double avg = room.getTotal() / room.getStus().size();
            System.out.println("班号为:" + room.getNo() + ",总分" + room.getTotal() + ",平均分" + avg);
        }
    }


    /**
     * 统计分数
     */
    public static void count(Map<String, ClassRoom> rooms, List<Student> list) {
        for (Student stu : list) {
            String no = stu.getNo();
            double score = stu.getScore();
            //根据班级编号 查看 Map是否存在该班级  分拣思路
            ClassRoom room = rooms.get(no);
            if (null == room) {  //第一次
                room = new ClassRoom(no);
                rooms.put(no, room);
            }
            //存储 总分
            room.setTotal(room.getTotal() + score);
            room.getStus().add(stu); //加入学生
        }
    }


    /**
     * 现在将若干Student对象放入List
     *
     * @param list
     */
    public static void exam(List<Student> list) {
        list.add(new Student("a", "001", 80));
        list.add(new Student("b", "001", 80));
        list.add(new Student("a", "002", 80));
        list.add(new Student("c", "003", 80));
        list.add(new Student("d", "003", 80));
    }
}
