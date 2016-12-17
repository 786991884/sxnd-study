package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCHelloWorld2 {
	public static void main(String[] args) {
		// 纯java方式直连mysql数据库
		// String classNam = "com.mysql.jdbc.Driver";
		// String url =
		// "jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8";
		// 线java方式直连oracle数据库
		// String className = "Oracle.jdbc.driver.OracleDriver";
		// String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		// java-odbc桥连oracle数据库
		// String className="sun.jdbc.odbc.JdbcOdbcDriver";
		// String url="jdbc:odbc:myorcl";
		// java-odbc桥连execel表
		String className = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:myexecel";
		/*
		 * //访问mysql或oracle数据库时 String user = "liu"; //数据库用户名 String password =
		 * "liu123456"; //数据库用户密码 String sqlUpdate =
		 * "insert into student(id,name,age) values(1,'xiaoli',20)"; //插入数据
		 * String sqlSelect = "select * from student"; //查询数据
		 */
		// 访问excel数据源时
		String sqlSelect = "select * from [student$]";// 如果是访问excel数据源,留意此处表名的写法
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// conn = DriverManager.getConnection(url, user, password);
			// //访问mysql/oracle数据库时
			conn = DriverManager.getConnection(url, "", ""); // 访问excel数据源,用户名和密码置为空
			stmt = conn.createStatement();
			// stmt=executeUpdate(sqlUpdate);
			rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) {
				System.out.println("id=" + rs.getInt("id") + ",name="
						+ rs.getString("name") + ",age=" + rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}
}
