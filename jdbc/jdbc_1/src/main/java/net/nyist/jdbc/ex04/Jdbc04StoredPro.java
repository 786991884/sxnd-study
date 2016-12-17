package net.nyist.jdbc.ex04;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.nyist.jdbc.ex03.JdbcUtil;

public class Jdbc04StoredPro {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		//首先定义三个
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql="call getUserById(?)";
			stmt=conn.prepareCall(sql);
			stmt.setInt(1, 3);
			rs=stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(rs, stmt, conn);
		}

	}

}
