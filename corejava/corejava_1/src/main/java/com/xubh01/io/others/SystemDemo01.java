package com.xubh01.io.others;

import java.io.*;
import java.util.Scanner;

/**
 * 三个常量
 * 1、System.in  输入流  键盘输入
 * 2、System.out 输出流   控制台输出
 * System.err
 * <p>
 * ==>重定向
 * setIn()
 * setOut()
 * setErr()
 * FileDescriptor.in
 * FileDescriptor.out
 */
public class SystemDemo01 {

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        //test1();
        //test2();
        //重定向
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("e:/xp/test/print.txt")), true));
        System.out.println("a");  //控制台  -->文件
        System.out.println("test");
        //回控制台
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
        System.out.println("back....");
    }

    public static void test2() throws FileNotFoundException {
        InputStream is = System.in;  //键盘输入
        is = new BufferedInputStream(new FileInputStream("e:/xp/test/print.txt"));
        Scanner sc = new Scanner(is);
        //System.out.println("请输入:");
        System.out.println(sc.nextLine());
    }

    public static void test1() {
        System.out.println("test");
        System.err.println("err");
    }

}
