package jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.rowset.CachedRowSetImpl;

/*
 * 使用行集分页
 * 使用结果集填充
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
			pstmt = conn.prepareStatement("select * from student",
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = pstmt.executeQuery();

			// 得到行集并填充数据
			CachedRowSetImpl rowset = new CachedRowSetImpl();
			rowset.setPageSize(4); // 设置每页行数
			rowset.populate(rs, 5); // 从结果集的第5行开始取数据

			// 结果集，preparedstatement，连接对象不能关闭，
			// 否则行集无法获得后续页数据
			// rs.close();
			// pstmt.close();
			// conn.close();

			System.out.println("从行集中输出数据，第一页：");
			System.out.println("id\tname\tage");
			while (rowset.next()) {
				System.out.print(rowset.getInt(1) + "\t");
				System.out.print(rowset.getString(2) + "\t");
				System.out.print(rowset.getInt(3) + "\n");
			}

			if (rowset.nextPage()) { // 获得后续页数据并输出
				System.out.println("第二页：");
				System.out.println("id\tname\tage");
				while (rowset.next()) {
					System.out.print(rowset.getInt(1) + "\t");
					System.out.print(rowset.getString(2) + "\t");
					System.out.print(rowset.getInt(3) + "\n");
				}
			}

			rowset.close(); // 关闭行集
			System.out.println("使用行集分页");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}