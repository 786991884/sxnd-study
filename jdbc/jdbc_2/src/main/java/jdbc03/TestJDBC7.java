package jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *使用Statement实现批量更新
 */
public class TestJDBC7 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8",
							"root", "1234");
			conn.setAutoCommit(false);// 设置事务非自动提交
			stmt = conn.createStatement();
			// 批量更新前查询数据
			rs = stmt.executeQuery("select * from student");
			conn.commit();// 主动提交事务
			System.out.println("批量添加前:");
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
			// 指更新
			stmt.addBatch("insert into student(id,name,age) values (1,'ceshi1',10)");
			stmt.addBatch("insert into student(id,name,age) values(2,'ceshi2',20)");
			stmt.addBatch("insert into student(id,name,age) values(3,'ceshi3',30)");
			int count[] = stmt.executeBatch();
			conn.commit();// 主动提交事务
			System.out.println("批量更新返回值:");
			for (int i = 0; i < count.length; i++) {
				System.out.println(count[i] + ",\t");
			}
			System.out.println();
			// 批量更新后查询数据
			rs = stmt.executeQuery("select * from student");
			conn.commit();// 主动提交事务
			System.out.println("批量添加后:");
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
