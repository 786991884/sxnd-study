package jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.rowset.CachedRowSetImpl;

/*
 * 使用行集删除数据
 */
public class TestJDBC7 {
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
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("select id,name,age from student");
			rs = pstmt.executeQuery();

			// 得到行集并填充数据
			CachedRowSetImpl rowset = new CachedRowSetImpl();
			rowset.populate(rs);

			// 结果集和preparedstatement可以关闭，
			// 连接对象不能关闭，行集修改数据库时可能会用到连接对象
			rs.close();
			pstmt.close();

			// 移动游标指向最后一行数据
			if (rowset.last()) {
				// 删除行集数据
				rowset.setTableName("student");
				rowset.deleteRow();
				rowset.acceptChanges(conn); // 修改数据库
			}

			rowset.close(); // 关闭行集
			System.out.print("使用行集删除数据成功");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}