package com.action;

import java.util.Map;

import com.bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OGNLAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// 普通属性Name
	private String name;
	// 学生对象
	private Student student;
	// map类型的request
	Map<String, Object> request;

	@SuppressWarnings("unchecked")
	public OGNLAction() {
		// 实例化学生对象
		student = new Student();
		student.setId(1);
		student.setName("张三");
		name = "tom";
		// 获取map类型的request
		request = (Map<String, Object>) ActionContext.getContext().get(
				"request");
	}

	// 请求处理方法
	@Override
	public String execute() throws Exception {
		// 向request添加值
		request.put("info", "request测试");
		// 返回success
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
