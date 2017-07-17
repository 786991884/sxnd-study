package com.xubh01.io.charIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xubh
 * @date 2017-06-14
 * @modify
 * @copyright
 */
public class MyTest {
    /**
     * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
     *
     * @param filePath 文件路径[到达文件:如： D:\aa.txt]
     * @return 将这个文件按照每一行切割成数组存放到list中。
     */
    public static List<String> readTxtFileIntoStringArrList(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt;

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) throws IOException {

        List<String> list1 = readTxtFileIntoStringArrList("C:\\githubrepo\\sxnd-study\\corejava\\corejava_1\\src\\main\\java\\com\\xubh01\\io\\charIO\\all.txt");
        List<String> list2 = readTxtFileIntoStringArrList("C:\\githubrepo\\sxnd-study\\corejava\\corejava_1\\src\\main\\java\\com\\xubh01\\io\\charIO\\delete.txt");
        /* 写入Txt文件 */
        File writename = new File("C:\\githubrepo\\sxnd-study\\corejava\\corejava_1\\src\\main\\java\\com\\xubh01\\io\\charIO\\delete_real.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
        writename.createNewFile(); // 创建新文件
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        for (String s : list1) {
            System.out.println(s.substring(39,75));
            if (list2.contains(s.substring(39,75))) {
                out.write(s + "\r\n");
                System.out.println(s);
            }
        }
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件
    }
}
