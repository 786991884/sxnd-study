package jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 并发控制
 * 事务隔离级别
 */
public class TestJDBC2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8",
							"root", "1234");
			conn.setAutoCommit(false); // 设置事务非自动提交
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);// 设置事务隔离级别,要求别的事务只能等该事务全部更改完才能读到新变更的数据。
			pstmt = conn
					.prepareStatement("insert into student(id,name,age) values(?,?,?)");
			pstmt.setInt(1, 11);
			pstmt.setString(2, "Oracle");
			pstmt.setInt(3, 23);
			int count = pstmt.executeUpdate();
			// 查询数据(同一事务中)
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
			conn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
			// 有任何一个事务执行不成功则回滚，将数据恢复到初试状态
			try {
				conn.rollback(); // 回滚
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
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
