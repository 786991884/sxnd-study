package com.xubh01.net.ip;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

/**
 * 没有封装端口
 */
public class InetDemo01 {

    /**
     * @param args
     * @throws UnknownHostException
     * @throws MalformedURLException
     */
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());  //返回：192.168.1.100
        System.out.println(addr.getHostName());  //输出计算机名
        //根据域名得到InetAddress对象
        addr = InetAddress.getByName("www.163.com");
        System.out.println(addr.getHostAddress());  //返回 163服务器的ip:61.135.253.15
        System.out.println(addr.getHostName());  //输出：www.163.com
        //根据ip得到InetAddress对象
        addr = InetAddress.getByName("61.135.253.15");
        System.out.println(addr.getHostAddress());  //返回 163服务器的ip:61.135.253.15
        System.out.println(addr.getHostName());  //输出ip而不是域名。如果这个IP地 址不存在或DNS服务器不允许进行IP地址和域名的映射，getHostName方法就直接返回这个IP地址。


    }

}
