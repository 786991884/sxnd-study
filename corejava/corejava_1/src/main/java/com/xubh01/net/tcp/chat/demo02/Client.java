package com.xubh01.net.tcp.chat.demo02;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端: 发送数据+接收数据
 * 写出数据：输出流
 * 读取数据：输入流
 * <p>
 * 输入流 与输出流 在同一个线程内 应该 独立处理，彼此独立
 */
public class Client {

    /**
     * @param args
     * @throws IOException
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        new Thread(new Send(client)).start(); //一条路径
        new Thread(new Receive(client)).start(); //一条路径

    }

}
