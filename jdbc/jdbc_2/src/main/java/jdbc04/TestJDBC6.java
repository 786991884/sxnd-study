package jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.rowset.CachedRowSetImpl;

/*
 * 使用行集添加数据
 */
public class TestJDBC6 {
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
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();

			// 得到行集并填充数据
			CachedRowSetImpl rowset = new CachedRowSetImpl();
			rowset.populate(rs);

			// 结果集和preparedstatement可以关闭，
			// 连接对象不能关闭，行集修改数据库时可能会用到连接对象
			// rs.close();
			// pstmt.close();

			rowset.last();

			rowset.setTableName("student"); // 使用行集添加数据时必须指定表名
			rowset.moveToInsertRow();
			rowset.updateInt("id", 11);
			rowset.updateString("name", "oracle");
			rowset.updateInt("age", 25);
			rowset.insertRow(); // 在行集中添加数据
			rowset.moveToCurrentRow();
			rowset.acceptChanges(conn); // 添加数据到数据库

			rowset.close(); // 关闭行集
			System.out.println("使用行集添加数据成功");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}