package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminLoginDao;
import com.admin.doimpl.AdminLoginDaoImpl;
import com.admin.entity.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// String path = request.getContextPath();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(password);
		// AdminLoginDao adminLoginDao = new AdminLoginDaoImpl();
		// boolean result = adminLoginDao.login(admin);
		if ("xbh".equals(name) && "123".equals(password)) {
			// ServletContext context = this.getServletContext();
			// request.getSession().setAttribute("admin", admin);
			// response.sendRedirect("Admin/pages/loginsuccess.jsp");
			request.getRequestDispatcher("/Admin/pages/loginsuccess.jsp")
					.forward(request, response);
			out.write("yes");
		} else {
			// response.sendRedirect(path + "/Admin/pages/error.jsp");
			request.getRequestDispatcher("/Admin/pages/error.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
