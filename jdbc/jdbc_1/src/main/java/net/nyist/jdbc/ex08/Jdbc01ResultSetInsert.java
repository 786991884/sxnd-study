package net.nyist.jdbc.ex08;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc01ResultSetInsert {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs=null;
		try {
			conn = JdbcUtil.getConnection();
			// 3 创建sql输入界面
			stmt = conn.createStatement();
			// 4输入sql并提交
			String sql = "select * from t_user";
			rs=stmt.executeQuery(sql);
			//插入
			rs.moveToInsertRow();
			rs.updateString("name", "范冰冰");
			rs.updateDate("birthday", new Date(System.currentTimeMillis()));
			rs.insertRow();
			rs.moveToCurrentRow();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7 关闭
			JdbcUtil.free(rs,stmt, conn);

		}

	}

}
