package com.oraclewdp.custag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class NestTag extends BodyTagSupport {
	private String name;
	private String value;

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println(getBodyContent());
		if (name.equals(value)) {
			//包含标记体
			return EVAL_BODY_INCLUDE;
		} else {
			//跳过标记体
			return SKIP_BODY;
		}
	}

	@Override
	public void doInitBody() throws JspException {
		System.out.println("doInitBody()");
		super.doInitBody();
	}
}
