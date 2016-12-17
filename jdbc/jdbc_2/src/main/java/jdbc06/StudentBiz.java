package jdbc06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * 根据条件查询学生信息，并将查询到的学生信息封装为Student对象
 * 将Student对象装入ArryList集合中返回。
 */
public class StudentBiz {
	public Collection<Student> findStuByAge(int age) {
		Collection<Student> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/test?useUnicode=true&charcterEnconding=utf-8",
							"root", "1234");
			pstmt = conn.prepareStatement("select * from student where age>?");
			pstmt.setInt(1, age);
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
