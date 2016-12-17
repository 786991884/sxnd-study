package jdbc02;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*用直接创建一个驱动对象的方式加载驱动*/
public class TestJDBC3 {
	public static void main(String[] args) {
		// 访问数据库需要使用的资源，最后需要释放
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			//Driver driver = new oracle.jdbc.driver.OracleDriver();
			Driver driver =null;
			DriverManager.registerDriver(driver);
			DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "hr", "1234");
			stmt = conn.createStatement();
			sql = "select * from student";
			rs = stmt.executeQuery(sql);
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
