package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "eshop", "1234");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	public static void free(ResultSet rs, Statement stmt, Connection conn) {
		// 关闭资源连接
		try {
			if (rs != null) {

				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
