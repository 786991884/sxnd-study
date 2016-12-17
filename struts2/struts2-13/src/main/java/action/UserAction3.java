package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class UserAction3 extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	@Override
	public String execute() throws Exception {
		if (user.getUsername().equals(user.getPassword())) {
			return "success";
		} else {
			return "error";
		}
	}
}
