package jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*用Class类的静态方法forName()加载驱动*/
/*查询表数据*/
public class TestJDBC1 {
	public static void main(String[] args) {
		// 访问数据库需要使用的资源，最后需要释放
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8";
		// 注册数据库驱动
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// 获得连接
			conn = DriverManager.getConnection(url, "root", "1234");
			// 获得statement对象
			stmt = conn.createStatement();
			// 执行sql语句
			sql = "select * from student";
			rs = stmt.executeQuery(sql);
			// 处理结果集
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
