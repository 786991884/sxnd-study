package jdbc02;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*使用prepareCall调用存储过程,插入数据*/
public class TestJDBC8 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8",
							"root", "1234");
			sql = "select * from student";
			rs = stmt.executeQuery(sql);
			System.out.println("调用存储过程前查询数据：");
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
			// 调用存储过程
			sql = "{call proc_insert_test(?,?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "sunqi");
			cstmt.setInt(2, 33);
			cstmt.executeUpdate();
			sql = "select * from student";
			rs = stmt.executeQuery(sql);
			System.out.println("\n\n\n调用存储过程后查询数据：");
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (cstmt != null) {
					cstmt.close();
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
