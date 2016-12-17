package com.xubh01.net.tcp.chat.demo02;

import java.io.Closeable;

/**
 * 关闭流的方法
 */
public class CloseUtil {
    public static void closeAll(Closeable... io) {
        for (Closeable temp : io) {
            try {
                if (null != temp) {
                    temp.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
