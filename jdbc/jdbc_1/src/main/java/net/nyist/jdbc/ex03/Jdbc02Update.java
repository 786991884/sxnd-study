package net.nyist.jdbc.ex03;

import java.sql.Connection;
import java.sql.Statement;

public class Jdbc02Update {

	public static void main(String[] args) throws Exception {
		Statement stmt=null;
		Connection conn=null;
		try {
			conn=JdbcUtil.getConnection();
			//3 创建sql输入界面
			stmt=conn.createStatement();
			//4输入sql并提交
			String sql="update t_user set pwd='789' where id=2";
			int result=stmt.executeUpdate(sql);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.free(null, stmt, conn);

		}

	}

}
