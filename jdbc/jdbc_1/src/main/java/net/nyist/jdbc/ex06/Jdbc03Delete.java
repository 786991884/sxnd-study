package net.nyist.jdbc.ex06;

import java.sql.Connection;
import java.sql.Statement;

public class Jdbc03Delete {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			// 3 创建sql输入界面
			stmt = conn.createStatement();
			// 4输入sql并提交
			String sql = "delete from t_user where id=6";
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7 关闭
			JdbcUtil.free(stmt, conn);

		}

	}

}
