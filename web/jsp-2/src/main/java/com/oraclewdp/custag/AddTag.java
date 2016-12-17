package com.oraclewdp.custag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AddTag extends SimpleTagSupport {
	private int num1;
	private int num2;

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public void doTag() throws IOException {
		JspContext ctx = getJspContext();
		JspWriter out = ctx.getOut();
		out.write(num1 + "+" + num2 + "=" + (num1 + num2));
	}
}
