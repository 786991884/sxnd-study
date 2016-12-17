package action;

import bean.StudentBean;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private StudentBean bean;

	public StudentBean getBean() {
		return bean;
	}

	public void setBean(StudentBean bean) {
		this.bean = bean;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(bean.getName());
		System.out.println(bean.getEmail());
		System.out.println(bean.getBirthday());
		System.out.println(bean.getHopeJob());
		return super.execute();
	}
}
