package com.oraclewdp.custag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class AddTag1 extends SimpleTagSupport {
	private double num1;
	private double num2;

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspContext jct = getJspContext();
		JspWriter jw = jct.getOut();
		if (num2 != 0) {
			jw.write(num1 + "/" + num2 + "=" + (num1 / num2));
		} else {
			System.out.println("除数不能为零");
			jw.write("除数能0吗");
		}

	}
}
