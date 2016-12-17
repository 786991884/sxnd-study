package day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

//学生类，可比较
class Student implements Comparable<Student> {
	private String name;// 姓名
	private int age; // 年龄

	// 构造方法

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Student stu) {
		if (this.age > stu.age) {
			return 1;
		} else if (this.age < stu.age) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	// 覆盖toString()方法
	public String toString() {
		return name + " " + age;
	}

}

// 测试主类
public class SortTest {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		// 添加4个学生对象
		list.add(new Student("stu001", 21));
		list.add(new Student("stu003", 29));
		list.add(new Student("stu002", 25));
		list.add(new Student("stu004", 23));
		System.out.println("-------原顺序----------");
		for (Iterator<Student> iter = list.iterator(); iter.hasNext();) {
			Student temp = iter.next();
			System.out.println(temp);
		}
		System.out.println("--------默认排列-----------");
		Collections.sort(list);
		for (Iterator<Student> iter = list.iterator(); iter.hasNext();) {
			Student temp = iter.next();
			System.out.println(temp);
		}
		System.out.println("---------降序排列---------");
		Comparator comp = Collections.reverseOrder();
		Collections.sort(list, comp);
		for (Iterator<Student> it = list.iterator(); it.hasNext();) {
			Student temp = it.next();
			System.out.println(temp);
		}
		System.out.println("--------按照名字重新排序---------");
		Collections.sort(list, new Comparator<Student>() {
			// 定义一个新的比较器
			@Override
			public int compare(Student s1, Student s2) {
				// 利用姓名升序排列
				return s1.getName().compareTo(s2.getName());
			}
		});
		for (Iterator<Student> it = list.iterator(); it.hasNext();) {
			Student temp = it.next();
			System.out.println(temp);
		}
	}
}
