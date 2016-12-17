package com.xubh01.io.util;

import java.io.Closeable;

public class FileUtil {

    /**
     * 工具类关闭流
     * 可变参数: ...  只能形参最后一个位置,处理方式与数组一致
     */
    public static void close(Closeable... io) {
        for (Closeable temp : io) {
            try {
                if (null != temp) {
                    temp.close();
                }
            } catch (Exception e) {
            }
        }

    }

    /**
     * 使用泛型方法
     */
    public static <T extends Closeable> void closeAll(T... io) {
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
