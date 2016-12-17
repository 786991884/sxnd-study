package com.xubh01.io.others;

import java.io.*;
import java.util.Arrays;

/**
 * 不是所有的對象都可以序列化  java.io.NotSerializableException
 * 不是所有的屬性都需要序列化  transient
 */
public class ObjectDemo01 {

    /**
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            seri("e:/xp/test/ser.txt");
            read("e:/xp/test/ser.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //反序列化
    public static void read(String destPath) throws IOException, ClassNotFoundException {
        //创建源
        File src = new File(destPath);
        //选择流
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new FileInputStream(src)));

        //操作 读取的顺序与写出一致   必须存在才能读取
        //不一致，数据存在问题
        Object obj = dis.readObject();
        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            System.out.println(emp.getName());
            System.out.println(emp.getSalary());
        }

        obj = dis.readObject();
        int[] arr = (int[]) obj;
        System.out.println(Arrays.toString(arr));
        dis.close();
    }

    //序列化
    public static void seri(String destPath) throws IOException {
        Employee emp = new Employee("xubh02", 1000000);
        int[] arr = {1, 2, 3, 45};
        //创建源
        File dest = new File(destPath);
        //选择流  ObjectOutputStream
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
        //操作 写出的顺序 为读取准备
        dos.writeObject(emp);
        dos.writeObject(arr);
        //释放资源
        dos.close();
    }
}
