package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;*/

/*Java-Odbc桥连oracle数据库*/
public class TestJDBC2 {
	public static void main(String[] args) {
		// 访问数据库需要使用的资源，最后需要释放
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		String className = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:myoracle";

		try {
			// 注册数据库驱动
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// 获得连接
			conn = DriverManager.getConnection(url, "hr", "1234");
			// 获得statement对象
			stmt = conn.createStatement();
			// 执行SQL语句
			sql = "select * from student";
			rs = stmt.executeQuery(sql);
			// 处理结果集
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 关闭对象，释放资源
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}