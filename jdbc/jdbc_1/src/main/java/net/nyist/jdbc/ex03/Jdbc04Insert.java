package net.nyist.jdbc.ex03;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc04Insert {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			// 3 创建sql输入界面
			stmt = conn.createStatement();
			// 4输入sql并提交
			String sql = "insert into t_user(name,pwd,age) values('赵六','456',26)";
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(null, stmt, conn);
		}

	}

}
