package jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*用Class类的静态方法forName()加载驱动*/
/*查询表数据*/
public class TestJDBC2 {
	public static void main(String[] args) {
		// 访问数据库需要使用的资源，最后需要释放
		Connection conn = null;
		Statement stmt = null;
		int count = 0;
		String sql = "";
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8";
		try {
			// 注册数据库驱动
			Class.forName(className);
			// 获得连接
			conn = DriverManager.getConnection(url, "root", "1234");
			// 获得statement对象
			stmt = conn.createStatement();
			// 执行sql语句
			sql = "update student set age=27 where id=1";
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 关闭对象，释放资源
			try {
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
