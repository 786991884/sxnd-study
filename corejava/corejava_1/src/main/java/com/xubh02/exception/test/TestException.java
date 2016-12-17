package com.xubh02.exception.test;


import java.io.File;
import java.io.FileNotFoundException;

public class TestException {
    public static void main(String[] args) {
//		int i = 1/0;
//		Computer c  = null;
//		if(c!=null){
//			c.start();   //对象是null，调用了对象方法或属性！
//		}

//		String str = "1234abcf";
//		Integer i = new Integer(str);

//		try{
//			Thread.sleep(3000);
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			System.out.println("aaa");
//		}

        File f = new File("c:/tt.txt");
        if (!f.exists()) {
            try {
                throw new FileNotFoundException("File can't be found!");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


    }
}

class Computer {
    void start() {
        System.out.println("计算机启动！");
    }
}