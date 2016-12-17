package action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import biz.BookBiz;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class UserAction3_5 extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware {

	private static final long serialVersionUID = 1L;
	private User user;
	private Map session;
	private Map application;
	private Map request;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public String execute() throws Exception {
		if (user.getUsername().equals(user.getPassword())) {
			// 会话中保存用户对象
			session.put("user", user);
			// 在应用程序中存所有书
			BookBiz bookBiz = new BookBiz();
			application.put("books", bookBiz.getBooks());
			return "success";
		} else {
			// 登录失败时加入失败信息在错误页显示
			request.put("errorinfo", "登录失败!");
			return "error";
		}
	}
}
