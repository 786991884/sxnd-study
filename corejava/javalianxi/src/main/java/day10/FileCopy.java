package day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		// 生成输入文件的输入流对象
		try {
			FileInputStream fin = new FileInputStream("d:/test/a.txt");
			// 生成输出文件的输出流对象
			FileOutputStream fout = new FileOutputStream("d:/test/b.txt");
			// 定义一个永固暂存数据的byte数组
			byte[] buff = new byte[256];
			int len = 0;// 每次读取数据的长度
			// 循环读取到buff中，如果文件到底，则读取数据的长度小于0
			while ((len = fin.read(buff)) > 0) {
				// 把数据一次写进输出文件中
				fout.write(buff, 0, len);
			}
			fin.close();// 关闭输入流
			fout.close();// 关闭输出流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
