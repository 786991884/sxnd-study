package action;

import com.opensymphony.xwork2.ActionSupport;

import entity.User4;

public class UserAction4_4 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private User4 user;

	public User4 getUser() {
		return user;
	}

	public void setUser(User4 user) {
		this.user = user;
	}

	public String login() {
		return ActionSupport.SUCCESS;
	}
}
