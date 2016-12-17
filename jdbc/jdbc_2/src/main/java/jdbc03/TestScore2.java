package jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 使用JDBC访问Score表，使用结果集向表中添加一行数据
 * 使用结果集将学号为3的学员的语文成绩提高10分
 * 使用结果集删除学号6的学员信息。
 */
public class TestScore2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8",
							"root", "1234");
			sql = "select id,chinese,english,history from score";
			stmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery();
			rs.moveToInsertRow();
			rs.updateInt(1, 11);
			rs.updateInt(2, 99);
			rs.updateInt(3, 99);
			rs.updateInt(4, 99);
			rs.insertRow();
			rs.moveToCurrentRow();
			System.out.println("添加数据成功...");

			// 使用结果集将学号为3的血液的语文成绩提高10分
			rs = null;
			stmt = null;
			stmt = conn.prepareStatement(
					"select id,chinese,english,history from score where id=?",
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setInt(1, 3);
			rs = stmt.executeQuery();
			if (rs.next()) {
				rs.updateInt("chinese", rs.getInt("chinese") + 10);
				rs.updateRow();
				System.out.println("修改数据成功...");
			} else {
				System.out.println("没有数据可更新...");
			}

			// 使用结果集删除学号6的学员信息
			rs = null;
			stmt = null;
			stmt = conn.prepareStatement(
					"select id,chinese,english,history from score where id=?",
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setInt(1, 6);
			rs = stmt.executeQuery();
			if (rs.next()) {
				rs.deleteRow();
				System.out.println("删除数据成功...");
			} else {
				System.out.println("没有数据可删...");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
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