package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import biz.BookBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class UserAction3_6 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		// HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ServletContext application = (ServletContext) ActionContext
				.getContext().get(ServletActionContext.SERVLET_CONTEXT);
		// ServletContext application =
		// ServletActionContext.getServletContext();
		if (user.getUsername().equals(user.getPassword())) {
			// 会话中存用户对象
			session.setAttribute("user", user);
			// 在应用程序中存所有书
			BookBiz bookBiz = new BookBiz();
			application.setAttribute("books", bookBiz.getBooks());
			return "success";
		} else {
			// 登录失败时加入失败信息在错误页显示
			request.setAttribute("errorinfo", "登录失败！");
			return "error";
		}
	}
}
