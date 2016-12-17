package jdbc02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*用读配置文件的方式加载驱动*/
public class TestJDBC4 {
	public static void main(String[] args) {
		// 访问数据库需要使用的资源，最后需要释放
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			File file = new File("d:\\test.properties");
			InputStream inStream = new BufferedInputStream(new FileInputStream(
					file));
			Properties p = new Properties();
			p.load(inStream);
			inStream.close();
			Class.forName(p.getProperty("jdbc.drivers"));
			// conn =
			// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","1234");
			conn = DriverManager.getConnection(p.getProperty("jdbc.url",
					"jdbc:oracle:thin:@localhost:1521:orcl"), "hr", "1234");
			stmt = conn.createStatement();
			sql = "select * from student where id<6";
			rs = stmt.executeQuery(sql);
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					stmt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
