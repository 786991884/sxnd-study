package com.Admin.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.vo.User;
import com.Admin.vo.UserPager;

/**
 * Servlet implementation class GetOneUserServlet
 */
@WebServlet("/getOneUserServlet")
public class GetOneUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetOneUserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id_str = request.getParameter("id");
		int id = 0;
		if (id_str != null) {
			id = Integer.parseInt(id_str);
		}
		UserPager userPager = (UserPager) request.getSession().getAttribute(
				"userPager");
		Map userMap = userPager.getUserMap();
		User user = (User) userMap.get(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("Admin/pages/manageDetailUser.jsp")
				.forward(request, response);
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
