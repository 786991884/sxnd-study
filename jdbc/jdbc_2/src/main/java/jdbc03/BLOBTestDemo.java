package jdbc03;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BLOBTestDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8",
							"root", "1234");
			stmt = conn
					.prepareStatement("insert into tbstu(id,name,resume,img) values(?,?,?,?)");
			stmt.setInt(1, 1);
			stmt.setString(2, "testname1");
			stmt.setClob(
					3,
					new InputStreamReader(BLOBTestDemo.class
							.getResourceAsStream("stu.txt")));
			stmt.setBlob(4, BLOBTestDemo.class.getResourceAsStream("stu.jpg"));
			int res = stmt.executeUpdate();
			System.out.println(res);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
