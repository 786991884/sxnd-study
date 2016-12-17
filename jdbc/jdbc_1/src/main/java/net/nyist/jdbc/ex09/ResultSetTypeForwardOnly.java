package net.nyist.jdbc.ex09;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import net.nyist.jdbc.ex06.JdbcUtil;

public class ResultSetTypeForwardOnly {

	public static void main(String[] args) {
		//首先定义三个
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			System.out.println(conn.getClass());
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from t_user");
			while (rs.next()) {
				int age = rs.getInt("age");
				String name = rs.getString("name");
				System.out.println("age=" + age + "\tname=" + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(rs, stmt, conn);
		}


	}

}
