package jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.rowset.CachedRowSetImpl;

/*
 * 行集的填充1：
 * 使用结果集填充
 */
public class TestJDBC3 {
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
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();

			// 得到行集并填充数据
			CachedRowSetImpl rowset = new CachedRowSetImpl();
			rowset.populate(rs);

			// 关闭结果集，preparedstatement，连接对象
			rs.close();
			pstmt.close();
			conn.close();

			System.out.println("结果集关闭，从行集中输出数据：");
			System.out.println("id\tname\tage");
			while (rowset.next()) {
				System.out.print(rowset.getInt(1) + "\t");
				System.out.print(rowset.getString(2) + "\t");
				System.out.print(rowset.getInt(3) + "\n");
			}
			rowset.close(); // 关闭行集
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}