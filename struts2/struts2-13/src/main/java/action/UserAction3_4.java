package action;

import java.util.Map;

import biz.BookBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class UserAction3_4 extends ActionSupport {
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
		ActionContext actionContext = ActionContext.getContext();
		if (user.getUsername().equals(user.getPassword())) {
			// 会话中存用户对象
			Map<String, Object> session = (Map<String, Object>) actionContext
					.getSession();
			session.put("user", user);
			// 在应用程序中存所有书
			Map<String, Object> application = actionContext.getApplication();
			BookBiz bookBiz = new BookBiz();
			application.put("books", bookBiz.getBooks());
			return "success";
		} else {
			// 登录失败时加入失败信息在错误页显示
			Map request = (Map) actionContext.get("request");
			request.put("errorinfo", "登录失败！");
			return "error";
		}
	}
}
