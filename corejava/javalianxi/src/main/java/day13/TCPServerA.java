package day13;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TCPServerA {
	public static void main(String[] args) throws Exception {
		// 用端口号创建一个ServerSocket对象
		ServerSocket ss = new ServerSocket(8888);
		Socket s = ss.accept();// 开始监听来自客户端的请求
		OutputStream os = s.getOutputStream();// 获得输出流
		PrintWriter pw = new PrintWriter(os);// 创建printwriter对象
		pw.print("now time=" + new Date());// 向输出流中写出当前时间
		pw.flush();// 清空缓存
		// 关闭输出流和Socket
		pw.close();
		s.close();
		ss.close();
	}
}
