package day10;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RanAccFileTest {
	public static void main(String[] args) throws IOException {
		// 创建随机读取文件对象
		RandomAccessFile file = new RandomAccessFile("d:/test/a.txt", "rw");
		// 遍历file的字节数据
		for (int i = 0; i < file.length(); i++) {
			byte b = (byte) file.read();// read方法读取一个字节
			char c = (char) b;// 转换为char
			if (c == 'a') {
				file.seek(i);// 把指针又恢复到之前的地方
				file.write('c');// 写入新的字符c
			}
		}
		// length()得到文件内容的字节长度
		// seek()设置到此文件开头测量到的文件指针偏移量，在该位置发生下一个读取或写入操作。
		// read和write读取和写入字节数据
		file.close();// 关闭文件的打开
	}
}
