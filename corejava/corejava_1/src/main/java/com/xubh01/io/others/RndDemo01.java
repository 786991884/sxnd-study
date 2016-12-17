package com.xubh01.io.others;

import com.xubh01.io.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件的分割思路
 * 1、分割的块数 size   n块
 * 2、每一块的大小 blockSize
 * 最后:总的文件大小 -(n-1)*blockSize
 */
public class RndDemo01 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        RandomAccessFile rnd = new RandomAccessFile(new File("E:/xp/20130502/test/test.java"), "r");
        rnd.seek(40);
        //定义缓冲大小
        byte[] flush = new byte[1024];
        //接收长度
        int len = 0;

        while (-1 != (len = rnd.read(flush))) {
            if (len >= 20) {
                System.out.println(new String(flush, 0, 20));
                break;
            } else {
                System.out.println(new String(flush, 0, len));
            }
        }

        FileUtil.close(rnd);

    }

}
