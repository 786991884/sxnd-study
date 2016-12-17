package jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *使用PreparedStatement实现批量更新
 */
public class TestJDBC8 {
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
			conn.setAutoCommit(false);// 设置事务非自动提交
			// 批量更新前查询数据
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();
			conn.commit();// 主动提交事务
			System.out.println("preparedstatement批量添加前:");
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
			// 批量更新
			pstmt = conn
					.prepareStatement("insert into student(id,name,age) values(?,?,?)");
			pstmt.setInt(1, 1);
			pstmt.setString(2, "name1");
			pstmt.setInt(3, 40);
			pstmt.addBatch();
			pstmt.setInt(1, 2);
			pstmt.setString(2, "name2");
			pstmt.setInt(3, 50);
			pstmt.addBatch();
			int count[] = pstmt.executeBatch();
			conn.commit();// 主动提交事务
			System.out.println("preparedstatement批量更新返回值:");
			for (int i = 0; i < count.length; i++) {
				System.out.println(count[i] + ",\t");
			}
			System.out.println();
			// 批量更新后查询数据
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();
			conn.commit();// 主动提交事务
			System.out.println("preparedstatement批量添加后:");
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
