package jdbc05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 使用Apache的DBCP连接池
 * 工程中需要导入
 * commons-collections-3.2.1.jar(连接池需要用到的)
 * commons-dbcp-1.4.jar(连接池需要用到的)
 * commons-pool-1.6.jar(连接池需要用到的)
 * ojdbc6.jar(oracle数据库驱动)
 * 不使用jdbc.properties文件，直接在程序中设置连接池相关属性(1)
 */
public class TestJDBC2 {
	public static void main(String args[]) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Properties pro = new Properties();
			// pro.load(new FileInputStream("jdbc.properties")); //读取连接池配置信息
			// pro.setProperty("driverClassName",
			// "oracle.jdbc.driver.OracleDriver");
			// pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
			// pro.setProperty("username", "liu");
			// pro.setProperty("password", "liu123456");
			// pro.setProperty("initialSize", "3");
			// pro.setProperty("maxActive", "10");
			// DataSource m = BasicDataSourceFactory.createDataSource(pro);
			BasicDataSource m = new BasicDataSource();
			m.setDriverClassName("com.mysql.jdbc.Driver");
			m.setUrl("jdbc:mysql://localhost:3306/test");
			m.setUsername("root");
			m.setPassword("1234");
			m.setInitialSize(3);
			m.setMaxActive(10);

			conn = m.getConnection();
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();
			System.out.println("id\tname\tage");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
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