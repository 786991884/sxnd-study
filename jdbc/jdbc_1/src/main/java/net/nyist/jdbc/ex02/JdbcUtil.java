package net.nyist.jdbc.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	//1安装客户端---仅需要加载一次
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取到数据库的连接
	 * @return
	 */
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 对于select要关闭三个，策略：1)重载2）判断
	 * 注意：关闭顺序
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
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
