package day13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//发送端
public class UDPClientA {
	public static void main(String[] args) throws SocketException, IOException {
		// 创建DatagramSocket,指定端口
		DatagramSocket ds = new DatagramSocket(9998);
		String str = "abc";
		// 用byte数组，创建数据包对象
		DatagramPacket dp = new DatagramPacket(str.getBytes(), 0, str.length(),
				InetAddress.getByName("localhost"), 9999);
		ds.send(dp);// 发送数据
		ds.close();// 关闭DatagramSocket
	}
}
