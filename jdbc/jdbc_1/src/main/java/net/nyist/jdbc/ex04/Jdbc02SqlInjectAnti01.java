package net.nyist.jdbc.ex04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.nyist.jdbc.ex03.JdbcUtil;

public class Jdbc02SqlInjectAnti01 {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		login("' or 1=1 or '", "");

	}

	public static void login(String uname, String pwd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			/**
			 * 拼接字符串方式使用sql注入仍然无法预防
			 *
			 */
			String sql = "select * from t_user  where name='" + uname
					+ "' and pwd='" + pwd + "'";
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("用户存在");
			}else{
				System.out.println("用户不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(rs, stmt, conn);
		}
	}
}
