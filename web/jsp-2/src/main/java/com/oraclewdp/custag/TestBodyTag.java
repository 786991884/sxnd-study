package com.oraclewdp.custag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class TestBodyTag extends BodyTagSupport {
	/**
	 *
	 */
	private static final long serialVersionUID = 2106058838311425187L;
	private int loop;

	public void setLoop(int loop) {
		this.loop = loop;
	}

	@Override
	public int doStartTag() throws JspException {
		if (loop > 0) {
			return Tag.EVAL_BODY_INCLUDE;

		} else {
			return Tag.SKIP_BODY;
		}
	}

	@Override
	public int doAfterBody() throws JspException {
		if (loop > 0) {
			loop--;
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;

		}
	}

	// 在web容器遇到标签结束时，该方法会运行，不定义该方法则遇到结束标签什么都不做
	@Override
	public int doEndTag() throws JspException {
		System.out.println("doEndTag()执行");
		return super.doEndTag();
	}
}
