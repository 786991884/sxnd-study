package day13;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TCPServerB {
	public static void main(String[] args) throws Exception {
		// 用端口号创建一个ServerSocket对象
		ServerSocket ss = new ServerSocket(8888);
		// 开始循环监听来自客户端的请求
		Socket s = null;
		while ((s = ss.accept()) != null) {
			// 开始一个新的线程
			new MyThread(s).start();
		}
		ss.close();
	}
}

// 线程类
class MyThread extends Thread {
	private Socket socket;// 连接点

	// 构造方法

	public MyThread(Socket socket) {
		super();
		this.socket = socket;
	}

	// 线程方法
	@Override
	public void run() {
		try {
			// 获得输出流
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			// 往输出流写出当前的时间
			pw.print("now time=" + new Date());
			pw.flush();// 清空缓存
			// 关闭输出流和Socket
			pw.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}