package jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 结果集游标定位
 */
public class TestJDBC3 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8",
							"root", "1234");
			sql = "select * from student";
			// sql = "select id,name,age from student";
			// pstmt = conn.prepareStatement(sql);
			// pstmt =
			// conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE);

			pstmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, // 不敏感，对数据库数据更改在记录集中不反应
					ResultSet.CONCUR_UPDATABLE, ResultSet.CONCUR_READ_ONLY);// 可以通过记录集修改数据
			rs = pstmt.executeQuery();
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
			rs.absolute(3);// 将指针指向第三行
			System.out.println("\n\n移动指针后重新输出：");
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
			rs.last();// 将指针指向最后一行
			System.out.println("\n\n移动指针后重新输出：");
			System.out.println("id\tname\tage");
			do {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			} while (rs.previous());// 将指针从最后一行逐步向第一行移动
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
