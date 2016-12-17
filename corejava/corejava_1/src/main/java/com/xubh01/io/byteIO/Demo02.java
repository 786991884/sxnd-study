package com.xubh01.io.byteIO;
import java.io.*;

/**
 * 写出文件
 * 1、建立联系   File对象  目的地
 * 2、选择流     文件输出流  OutputStream FileOutputStream
 * 3、操作  :  write() +flush
 * 4、释放资源 :关闭
 */
public class Demo02 {

    public static void main(String[] args) {
        //1、建立联系   File对象  目的地
        File dest = new File("e:/xp/test/test.txt");
        //2、选择流   文件输出流  OutputStream FileOutputStream
        OutputStream os = null;
        //以追加形式 写出文件 必须为true 否则为覆盖
        try {
            os = new FileOutputStream(dest, true);
            //3、操作
            String str = "xubh02 is very good \r\n";
            //字符串转字节数组
            byte[] data = str.getBytes();
            os.write(data, 0, data.length);

            os.flush(); //强制刷新出去
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写出失败");
        } finally {
            //4、释放资源 :关闭
            try {
                if (null != os) {
                    os.close();
                }
            } catch (Exception e2) {
                System.out.println("关闭输出流失败");
            }
        }
    }

}
