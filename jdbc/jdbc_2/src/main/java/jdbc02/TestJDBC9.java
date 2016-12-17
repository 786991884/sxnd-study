package jdbc02;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*使用prepareCall调用存储过程,查询数据*/
public class TestJDBC9 {
	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			//Driver drv = new oracle.jdbc.driver.OracleDriver();
			Driver drv =null;
					DriverManager.registerDriver(drv);
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "hr", "1234");

			// 调用存储过程
			sql = "{call proc_select_test(?,?,?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, 190);
			cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			// rs = cstmt.executeQuery();
			cstmt.executeQuery();
			System.out.println("存储过程返回的数据：");
			System.out.println("age\tname");
			System.out.print(cstmt.getString(2) + "\t");
			System.out.println(cstmt.getString(3) + "\n");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
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