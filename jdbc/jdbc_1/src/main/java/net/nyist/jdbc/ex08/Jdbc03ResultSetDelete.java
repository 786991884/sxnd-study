package net.nyist.jdbc.ex08;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc03ResultSetDelete {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs=null;
		try {
			conn = JdbcUtil.getConnection();
			// 3 创建sql输入界面
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			// 4输入sql并提交
			String sql = "select * from t_user";
			rs=stmt.executeQuery(sql);
			//告诉删除那一行
			rs.last();
			rs.deleteRow();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7 关闭
			JdbcUtil.free(rs,stmt, conn);

		}

	}

}
