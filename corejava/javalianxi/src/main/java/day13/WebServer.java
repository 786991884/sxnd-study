package day13;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//web服务端
public class WebServer {
	public static void main(String[] args) throws IOException {
		// 用端口号创建一个ServerSocket对象，监听Web的端口80
		ServerSocket ss = new ServerSocket(80);
		// 开始循环监听来自客户端的请求
		Socket s = null;
		while ((s = ss.accept()) != null) {
			new HTTPThread(s).start();// 开始一个新的线程
		}
	}
}

// 线程类，HTTP处理线程
class HTTPThread extends Thread {
	private Socket socket;// 连接点

	public HTTPThread(Socket socket) {
		super();
		this.socket = socket;
	}

	// 线程方法
	@Override
	public void run() {

		try {
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			// 往输出流写出当前的时间
			pw.println("<html>");
			pw.println("<body>");
			pw.println("hello this is my web page.");
			pw.println("</body>");
			pw.println("</html>");
			pw.flush();// 清空缓存
			// 关闭输出流和Socket
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}