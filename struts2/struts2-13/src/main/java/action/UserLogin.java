package action;

public class UserLogin {

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {
		if (name.equals("zs")) {
			return "ok";
		} else {
			return "error";
		}
	}

	public String doAdd() {
		return "doAdd";
	}
}
