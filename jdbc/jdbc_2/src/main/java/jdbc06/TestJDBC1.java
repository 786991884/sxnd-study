package jdbc06;

import java.util.Collection;

/*
 * 通过StudentBiz查询学生信息，然后将学生信息输出
 */
public class TestJDBC1 {
	public static void main(String[] args) {
		StudentBiz stuBiz = new StudentBiz();
		Collection<Student> list = stuBiz.findStuByAge(10);
		System.out.println("年龄大于10的学生信息：");
		System.out.println("id\tname\tage");
		for (Student stu : list) {
			System.out.print(stu.getId() + "\t");
			System.out.print(stu.getName() + "\t");
			System.out.print(stu.getAge() + "\n");
		}
	}
}
