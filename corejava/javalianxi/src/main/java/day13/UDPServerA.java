package day13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//接收端
public class UDPServerA {
	public static void main(String[] args) throws IOException {
		// 创建DatagramSocket,指定端口
		DatagramSocket ds = new DatagramSocket(9999);
		// 创建一个byte数组
		byte[] buff = new byte[1024];
		// 创建一个数据包对象
		DatagramPacket dp = new DatagramPacket(buff, 1024);
		ds.receive(dp);// 接收消息
		String str = new String(dp.getData(), 0, dp.getLength());// 得到数据
		System.out.println(str);// 打印数据
		ds.close();
	}
}
