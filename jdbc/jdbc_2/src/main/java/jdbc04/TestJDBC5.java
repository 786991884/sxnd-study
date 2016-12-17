package jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.rowset.CachedRowSetImpl;

/*
 * 使用行集更新数据
 */
public class TestJDBC5 {
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
			pstmt = conn
					.prepareStatement("select name,age from student where id=?");
			pstmt.setInt(1, 2);// id=2
			rs = pstmt.executeQuery();

			// 得到行集并填充数据
			CachedRowSetImpl rowset = new CachedRowSetImpl();
			rowset.populate(rs);

			// 结果集和preparedstatement可以关闭，
			// 连接对象不能关闭，行集修改数据库时可能会用到连接对象
			rs.close();
			pstmt.close();

			rowset.next(); // 移动游标指向第一行数据

			// 修改数据
			// 修改id为2的学员信息
			rowset.setTableName("student");
			rowset.updateString("name", "wuyuanping");
			rowset.updateInt("age", 28);
			rowset.updateRow(); // 修改行集
			rowset.acceptChanges(conn); // 使用conn连接对象，修改数据库

			rowset.close(); // 关闭行集
			System.out.println("使用行集更新数据 成功");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}