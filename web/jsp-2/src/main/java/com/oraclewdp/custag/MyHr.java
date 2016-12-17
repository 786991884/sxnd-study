package com.oraclewdp.custag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyHr extends TagSupport {
	/**
	 *
	 */
	private static final long serialVersionUID = -1065516373575602933L;

	// 当读到开始标签时调用该方法
	@Override
	public int doStartTag() throws JspException {
		try {
			// 得到网络输出流，pageContext是从父类继承过来的成员
			JspWriter out = pageContext.getOut();
			// 向网页输出内容
			out.println("<h2>开始执行doStartTag().....</h2>");
			// 输出5条水平线
			for (int i = 0; i <= 5; i++) {
				out.println("<hr>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;// 处理标记体
		// return Tag.SKIP_BODY;//跳过标记体;
	}

	@Override
	// 读取到结束标签时调用该方法
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.println("<h3>开始执行doEndTag()........</h3>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// return Tag.SKIP_PAGE;// 返回这个值，则终止页面执行;
		return EVAL_PAGE;// 告诉继续显示其余的标签
	}
}
