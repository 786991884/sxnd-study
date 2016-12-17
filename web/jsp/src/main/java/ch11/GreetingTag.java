package ch11;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class GreetingTag extends SimpleTagSupport {
	private String user;

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		getJspContext().getOut().println("hello," + user);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
