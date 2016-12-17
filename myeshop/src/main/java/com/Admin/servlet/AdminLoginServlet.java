package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminLoginDao;
import com.Admin.daoimpl.AdminLoginDaoImpl;
import com.Admin.vo.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getContextPath();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(password);
		AdminLoginDao adminLoginDao = new AdminLoginDaoImpl();
		boolean result = adminLoginDao.login(admin);
		if (result) {
			ServletContext context = this.getServletContext();
			// List adminList = (List) context.getAttribute("adminList");
			// System.out.println(adminList.size());
			// if (adminList.contains("admin")) {
			request.getSession().setAttribute("admin", admin);
			request.getSession().setAttribute("merchantId", admin);
			response.sendRedirect("Admin/pages/adminConter.jsp");
			// } else{
			// request.setAttribute("message", "已登录");
			// request.getRequestDispatcher("Admin/login/adminLogin.jsp").forward(request,
			// response);
		} else {
			response.sendRedirect(path + "/Admin/pages/error.jsp");
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
