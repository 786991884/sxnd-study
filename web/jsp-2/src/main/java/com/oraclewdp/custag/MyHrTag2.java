package com.oraclewdp.custag;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class MyHrTag2 extends TagSupport {
	private String color = "black";// 定义线条颜色
	private String loop = "1";// 定义输出水平线的条数

	// 严格按照javabean模式

	public void setColor(String color) {
		this.color = color;
	}

	public void setLoop(String loop) {
		this.loop = loop;
	}

	// 只定义遇到开始标签执行方法即可了
	@Override
	public int doStartTag() throws JspException {
		try {
			// 得到网络输出流
			JspWriter out = pageContext.getOut();
			// 向网页输出内容
			out.println("<h3>开始执行doStartTag().....</h4>");
			int n = Integer.parseInt(loop);
			for (int i = 1; i <= n; i++) {
				out.print("<hr color='" + this.color + "'/");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;

	}
}
