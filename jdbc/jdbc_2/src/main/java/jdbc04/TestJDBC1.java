package jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 使用事务
 */
public class TestJDBC1 {
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

			pstmt = conn
					.prepareStatement("update student set age=age+? where id=?");
			pstmt.setInt(1, 10);
			pstmt.setInt(2, 5);
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("update student set name=? where id=?");
			pstmt.setString(1, "liusanjie");
			pstmt.setInt(2, 11);
			pstmt.executeUpdate();

			// conn.commit(); //提交事务
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();
			// conn.commit();

			System.out.println("事务执行后：");
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}

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
