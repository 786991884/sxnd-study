package com.wq.dao;

import java.util.ArrayList;
import java.util.List;

import com.wq.vo.PageBean;
import com.wq.vo.Student;

public class StudentDao {
	private List<Student> students = null;

	public StudentDao() {
		students = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			students.add(new Student(i, "学生" + i, (i % 4 == 0 ? "男" : "女"),
					20 + i % 3));
		}
	}

	// 获取每页的相关数据，将数据封装到pageBean中
	public PageBean getPageBean(int index, int pageSize) {
		PageBean pb = new PageBean();
		pb.setIndex(index);
		pb.setPageSize(pageSize);
		pb.setTotal(students.size());
		List<Student> pageData = students.subList((index - 1) * pageSize, index
				* pageSize);
		pb.setData(pageData);
		return pb;
	}
}
