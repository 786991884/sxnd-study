package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClientA {
	public static void main(String[] args) throws IOException, IOException {
		// 用IP地址和端口号创建Socket对象
		Socket s = new Socket("localhost", 8888);
		// 获得输入流
		InputStream is = s.getInputStream();
		// 创建BufferReader对象
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();// 读取一行
		br.close();
		isr.close();
		is.close();
		s.close();
		System.out.println(str);// 打印从服务器来的结果
	}
}
