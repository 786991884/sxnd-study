package net.nyist.jdbc.ex04;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.nyist.jdbc.ex03.JdbcUtil;

public class Jdbc01SqlInject {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		//构造特殊的字符串来使得绕过验证
		login("' or 1=1 or '", "");

	}

	public static void login(String uname,String pwd){
		//首先定义三个
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			//拼接字符串方式
			String sql="select * from t_user  where name='"+uname+"' and pwd='"+pwd+"'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
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
