package jdbc03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 使用CallableStatement实现批量更新
 */
public class TestJDBC9 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8",
							"root", "1234");
			conn.setAutoCommit(false);// 设置事务非自动提交
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();
			conn.commit();
			System.out.println("callablestatement批量添加前：");
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
			// 批量更新
			cstmt = conn.prepareCall("{call proc_insert_test(?,?,?)}");
			cstmt.setInt(1, 1);
			cstmt.setString(2, "xiaoming1");
			cstmt.setInt(3, 123);
			cstmt.addBatch();
			cstmt.setInt(1, 2);
			cstmt.setString(2, "xiaoming2");
			cstmt.setInt(3, 13);
			cstmt.addBatch();
			int count[] = cstmt.executeBatch();
			conn.commit();
			System.out.println("callablestatement批量更新返回值:");
			for (int i = 0; i < count.length; i++) {
				System.out.println(count[i] + ",\t");
			}
			System.out.println();
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();
			conn.commit();
			System.out.println("callablestatement批量添加后:");
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
