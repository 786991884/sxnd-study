package ch11;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyOwnSimpleTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		getJspContext().getOut().write("this is my tag");
	}
}
