package jdbc05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

/*
 * 使用Apache的DBCP连接池
 * 工程中需要导入
 * commons-collections-3.2.1.jar(连接池需要用到的)
 * commons-dbcp-1.4.jar(连接池需要用到的)
 * commons-pool-1.6.jar(连接池需要用到的)
 * ojdbc6.jar(oracle数据库驱动)
 * 在工程中创建jdbc.properties文件，并在其中配置连接池相关属性
 */
public class TestJDBC1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Properties pro = new Properties();
			InputStream in = ClassLoader
					.getSystemResourceAsStream("jdbc.properties");
			pro.load(in);// 读取连接池配置信息
			DataSource m = BasicDataSourceFactory.createDataSource(pro);
			conn = m.getConnection();
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();
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
