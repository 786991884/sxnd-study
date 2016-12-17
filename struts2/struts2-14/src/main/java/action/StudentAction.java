package action;

import bean.Student;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Student student;

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
