package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	// private static final String driverClass = "com.mysql.jdbc.Driver";
	// private static final String DB_URL =
	// "jdbc:mysql://localhost:3306/jdbctest?user=root&password=1234";
	private static final String driverClass = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";

	private JDBCUtils() {

	}

	static {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, "hr", "1234");
	}

	public static void free(ResultSet rs, PreparedStatement pt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			if (null != pt) {
				pt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
