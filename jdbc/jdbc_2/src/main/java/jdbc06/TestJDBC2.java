package jdbc06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/*
 * 采用两层结构访问student表中的数据
 * TestJDBC2为客户端，数据库为服务器端
 * 提出请求，对数据库进行访问，展示数据都在TestJDBC2类中
 *
 * TestJDBC2:显示层+业务逻辑层(客户端)
 * 数据库:数据层
 */
public class TestJDBC2 {
	public static void main(String[] args) {
		Collection<Student> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
							"liu", "liu123456");
			pstmt = conn.prepareStatement("select * from student where age>?");
			pstmt.setInt(1, 20);
			rs = pstmt.executeQuery();

			list = new ArrayList<Student>();
			Student stu = null;

			while (rs.next()) {
				stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setAge(rs.getInt(3));

				list.add(stu);
			}

			// 显示出来
			System.out.println("年龄大于24岁的学生信息:");
			for (Student student : list) {
				System.out.print(student.getId() + "\t");
				System.out.print(student.getName() + "\t");
				System.out.print(student.getAge() + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
