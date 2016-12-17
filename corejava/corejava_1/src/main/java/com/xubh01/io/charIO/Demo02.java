package com.xubh01.io.charIO;

import java.io.*;

/**
 * 写出文件
 */
public class Demo02 {

    public static void main(String[] args) {
        //创建源
        File dest = new File("e:/xp/test/char.txt");
        //选择流
        Writer wr = null;
        try {
            //追加文件，而不是覆盖文件
            wr = new FileWriter(dest);
            //写出
            String msg = "追加.....锄禾日当午\r\n码农真辛苦\r\n一本小破书\r\n一读一上午";
            wr.write(msg);
            wr.append("倒萨发了看电视剧 ");

            wr.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != wr) {
                    wr.close();
                }
            } catch (Exception e2) {
            }
        }
    }

}
