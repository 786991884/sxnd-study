package net.nyist.jdbc.ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	static{
		/**
		 * 安装客户端的四种方式
		 */
		//1.1 安装客户端
		try {
			//修改1
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	/*1.2 安装方法---在程序中，你去手动注册(注册了两次,紧密的绑定在一起)
	 *
	 */
	/* try {
		DriverManager.registerDriver(new Driver());
	} catch (SQLException e) {
		e.printStackTrace();
	}*/
	/*
	 * 1.3 jdbc4.0+版本，不用用户显式地注册
	 * 原理：DriverManager某人地会到META-INF/services/java.sql.Driver文件中去读取驱动
	 * 使用注意：如果你的jdbc驱动版本jdbc3.0及其以下
	 */
		/**
		 * 1.4 通过设置系统变量jdbc.drivers的值来注册驱动，如果有多个驱动类以冒号分割，例如：
		 *    foo.bah.Driver:wombat.sql.Driver:bad.taste.ourDriver
		 *  优点：可以注册多个
		 *  缺点：有时候由于权限限制，可能修改不成功
		 */
		// System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
	}
	public static Connection getConnection(){
		try {
			//通过DriverManager获取Connection的三种方式
			/**
			 * 1三个参数的
			 */
			//修改第二部分
			//return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "nyist", "nyist");
			/**
			 * 2 一个参数的(对于mysql，需要把用户名和密码作为参数)
			 */
			// return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
			/**
			 * 3 两个参数
			 */
		/* Properties info=new Properties();
		 info.setProperty("user", "root");
		 info.setProperty("password", "root");
		 return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", info);*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//对于select要关闭三个，策略：1)重载2）判断
	public static void free(ResultSet rs,Statement stmt,Connection conn){
	/* if (rs!=null) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}