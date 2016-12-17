package net.nyist.jdbc.ex07;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * JDBC:是Oracle公司发布的标准，然后各个数据库厂商根据该标准提供实现类，实现类的集合就是驱动包
 * Oracle只规定接口，各个数据库厂商提供接口的实现类
 * orcale关于数据库的类所在包：java.sql,javax.sql
 * ODBC:open database connetion 微软公司公司为了让程序几乎不用修改能链接到各个数据库
 * @author Administrator
 *
 */
public class Jdbc03BatchUpdatePro {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		//首先定义三个
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			System.out.println(conn.getClass());
			stmt = conn.createStatement();
			//故意产生错误
			String sql1="delete from t_user1 where id=6";
			//添加发送的语句
			stmt.addBatch(sql1);
			String sql2="update t_user set pwd='231' where id=3";
			stmt.addBatch(sql2);
			int[]results=stmt.executeBatch();//抛出异常，无法得到别的语句执行效果
			for (int i : results) {
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(stmt, conn);
		}

	}

}
