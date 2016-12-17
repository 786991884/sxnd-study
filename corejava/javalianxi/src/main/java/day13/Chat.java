package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//聊天类
public class Chat {
	public static void main(String[] args) {
		// args format:接收端口、发送端口、对方接收端口
		// 启动接收线程
		new ReceiveThread(Integer.parseInt(args[0])).start();
		// 启动发送线程
		new SendThread(Integer.parseInt(args[1]), Integer.parseInt(args[2]))
				.start();
	}
}

// 接收线程
class ReceiveThread extends Thread {
	private DatagramSocket ds;

	// 构造方法
	public ReceiveThread(int port) {
		super();
		try {
			this.ds = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// 创建byte数组
		byte[] buff = new byte[1024];
		// 创建一个数据包对象
		DatagramPacket dp = new DatagramPacket(buff, 1024);
		// 永真循环
		while (true) {
			try {
				ds.receive(dp);// 接收消息
				// 得到数据
				String str = new String(dp.getData(), 0, dp.getLength());
				System.out.println("receive:" + str);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				ds.close();
			}
		}
	}
}

// 发送线程类
class SendThread extends Thread {
	private DatagramSocket ds;
	private int sendPort;

	public SendThread(int port, int sendPort) {
		super();
		this.sendPort = sendPort;
		try {
			this.ds = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// 循环接收用户输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			while ((str = br.readLine()) != null) {
				// 创建DatagramPacket对象
				DatagramPacket dp = new DatagramPacket(str.getBytes(), 0,
						str.length(), InetAddress.getByName("localhost"),
						sendPort);
				ds.send(dp);// 发送数据
				System.out.println("send:" + str);// 打印结果
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ds.close();
		}
	}
}