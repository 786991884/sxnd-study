package jdbc02;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestJDBC6 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			//Driver drv = new oracle.jdbc.driver.OracleDriver();
			Driver drv = null;
			DriverManager.registerDriver(drv);

			Properties pro = new Properties();
			pro.setProperty("user", "liu");
			pro.setProperty("password", "liu123456");
			conn = drv.connect("jdbc:oracle:thin:@localhost:1521:orcl", pro);

			stmt = conn.createStatement();
			sql = "select * from student";
			rs = stmt.executeQuery(sql);

			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					stmt.close();
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