package com.xubh02.test.file;

import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        File f = new File("d:/src3/TestObject.java");
        File f2 = new File("d:/src3");
        File f3 = new File(f2, "TestThis.java");
        File f4 = new File(f2, "TestFile666.java");
        File f5 = new File("d:/src3/aa/bb/cc/ee/ddd");
        f5.mkdirs();
        //f4.createNewFile();
//		f4.delete();
        if (f.isFile()) {
            System.out.println("是一个文件");
        }
        if (f2.isDirectory()) {
            System.out.println("是一个目录");
        }

    }
}
