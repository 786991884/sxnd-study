package day10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReaderTest {
	public static void main(String[] args) throws IOException {
		// 获取输入流
		InputStream in = new FileInputStream("d:/test/a.txt");
		// 得到InputStreamReader对象
		InputStreamReader isr = new InputStreamReader(in, "GBK");
		BufferedReader br = new BufferedReader(isr);// 创建reader对象
		// 创建StringBuffer对象，临时保存字符内容
		StringBuffer sb = new StringBuffer();
		String str = null;
		// 循环读取一行数据
		while ((str = br.readLine()) != null) {
			// 加入字符串
			sb.append(str);
		}
		PrintWriter pw = new PrintWriter(new FileOutputStream("d:/test/b.txt"));
		pw.println("a");
		pw.println("b");
		pw.close();
		System.out.println("a.txt content:" + sb);
		br.close();
	}
}
