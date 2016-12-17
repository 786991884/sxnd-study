package net.nyist.jdbc.ex06;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static Properties p;
	static {
		p = new Properties();
		try {
			p.load(JdbcUtil.class.getResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static {
		/**
		 * 安装客户端的四种方式
		 */
		// 1.1 安装客户端
		try {
			// 修改1
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName(p.getProperty("driverClass"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*
		 * 1.2 安装方法---在程序中，你去手动注册(注册了两次,紧密的绑定在一起)
		 */
		/*
		 * try { DriverManager.registerDriver(new Driver()); } catch
		 * (SQLException e) { e.printStackTrace(); }
		 */
		/*
		 * 1.3 jdbc4.0+版本，不用用户显式地注册
		 * 原理：DriverManager某人地会到META-INF/services/java.sql.Driver文件中去读取驱动
		 * 使用注意：如果你的jdbc驱动版本jdbc3.0及其以下
		 */
		/**
		 * 1.4 通过设置系统变量jdbc.drivers的值来注册驱动，如果有多个驱动类以冒号分割，例如：
		 * foo.bah.Driver:wombat.sql.Driver:bad.taste.ourDriver 优点：可以注册多个
		 * 缺点：有时候由于权限限制，可能修改不成功
		 */
		// System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
	}

	public static Connection getConnection() {
		try {
			// 通过DriverManager获取Connection的三种方式
			/**
			 * 1三个参数的
			 */
			// 修改第二部分
			// return
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
			// "root", "root");
			return DriverManager.getConnection(p.getProperty("conntionurl"),
					p.getProperty("username"), p.getProperty("pwd"));
			// return
			// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
			// "nyist", "nyist");
			/**
			 * 2 一个参数的(对于mysql，需要把用户名和密码作为参数)
			 */
			// return
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
			/**
			 * 3 两个参数
			 */
			/*
			 * Properties info=new Properties(); info.setProperty("user",
			 * "root"); info.setProperty("password", "root"); return
			 * DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
			 * info);
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 对于select要关闭三个，策略：1)重载2）判断3)不定参数
	/*
	 * 资源释放方式1：重载形式
	 */
/*public static void free( Statement stmt, Connection conn) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
public static void free(ResultSet rs, Statement stmt, Connection conn) {

	if (rs != null) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if (stmt != null) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if (conn != null) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}*/
	/*
	 * 资源释放方式2：判断方式
	 */
	/*public static void free(ResultSet rs, Statement stmt, Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}*/
	/*
	 * 资源释放方式三：不定参数形式
	 */
	public static void free(Object...objs) {
		for (int i = 0; i < objs.length; i++) {
			if (objs[i] instanceof Connection) {
				try {
					((Connection)objs[i]).close();
					continue;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (objs[i] instanceof Statement) {
				try {
					((Statement)objs[i]).close();
					continue;
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (objs[i] instanceof ResultSet) {
				try {
					((ResultSet)objs[i]).close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
