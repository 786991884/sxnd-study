package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCHelloWorld {
	public static void main(String[] args) {
		String className = "com.mysql.jdbc.Driver";
		// String className="oracle.jdbc.driver.OracleDriver";
		// String className = "oracle.jdbc.OracleDriver";
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8";
		// String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "root";
		String password = "1234";
		String sqlUpdate = "insert into student(id,name,age) values (1,'xiaoli',20)";
		String sqlSelect = "select * from student";
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
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlUpdate);
			rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) {
				System.out.print("name=" + rs.getString("name"));
				System.out.println(",age" + rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
