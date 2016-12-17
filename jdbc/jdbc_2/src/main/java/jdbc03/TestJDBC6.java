package jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.jasper.tagplugins.jstl.core.When;

/*
 * 通过结果集添加数据
 */
public class TestJDBC6 {
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
			pstmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, // 不敏感，对数据库数据更改在记录集中不反应
					ResultSet.CONCUR_UPDATABLE, ResultSet.CONCUR_READ_ONLY);// 可以通过记录集修改数据
			rs = pstmt.executeQuery();
			System.out.println("添加前数据：");
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
			rs.moveToCurrentRow();// 游标定位到插入行(其实是个缓冲区)
			rs.updateInt(1, 1);
			rs.updateString("name", "tianjia");// 为姓名列赋值
			rs.updateInt(3, 200); // 为年龄列赋值
			rs.insertRow(); // 将新添加的数据写入数据库,id自动增长
			rs = pstmt.executeQuery();
			System.out.println("\n\n通过记录集添加数据后重新查询数据并输出：");
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
