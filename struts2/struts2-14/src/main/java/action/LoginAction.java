package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		if (this.getUsername().equals("root")
				&& this.getPassword().equals("1234")) {
			context.getSession().put("user", this.getUsername());
			context.put(
					"message",
					getText("login_welcome",
							new String[] { this.getUsername() }));
			return "loginSuccess";
		} else {
			context.put("message", getText("login_failure"));
			return "loginFailure";
		}
	}
}
