package com.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制页面语言的切换
 */
/**
 * Servlet implementation class LanguageManager
 */
public class LanguageManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LanguageManager() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String lang = request.getParameter("language");// 获取参数
		Locale language = null; // 定义Locale对象
		if (lang.equals("1")) {
			language = Locale.CHINA;// 中文
		} else {
			language = Locale.US;// 英文
		}
		request.setAttribute("language", language);
		// 跳转到添加页面上
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
				"/index8.jsp");
		rd.forward(request, response);

	}

}
