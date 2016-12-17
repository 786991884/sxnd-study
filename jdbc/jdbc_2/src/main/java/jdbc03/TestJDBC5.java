package jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.jasper.tagplugins.jstl.core.When;

/*
 * 通过结果集删除数据
 */
public class TestJDBC5 {
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
			sql = "select id,name,age from student";
			// pstmt = conn.prepareStatement(sql);
			// pstmt =
			// conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE);

			pstmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, // 不敏感，对数据库数据更改在记录集中不反应
					ResultSet.CONCUR_UPDATABLE, ResultSet.CONCUR_READ_ONLY);// 可以通过记录集修改数据
			rs = pstmt.executeQuery();
			System.out.println("删除前数据：");
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
			rs.absolute(3);// 游标定位到第一行数据
			rs.deleteRow();// 删除游标指定行的数据
			rs = pstmt.executeQuery();
			System.out.println("\n\n通过记录集删除数据后重新查询数据并输出：");
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
