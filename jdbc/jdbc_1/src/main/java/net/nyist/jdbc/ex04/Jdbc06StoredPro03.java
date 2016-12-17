package net.nyist.jdbc.ex04;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import net.nyist.jdbc.ex03.JdbcUtil;

public class Jdbc06StoredPro03 {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		//首先定义三个
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();

			String sql="call abs2(?)";
			stmt=conn.prepareCall(sql);
			stmt.setInt(1, -10);
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.executeUpdate();
			System.out.println("-10的绝对值："+stmt.getInt(1));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(rs, stmt, conn);
		}

	}

}
