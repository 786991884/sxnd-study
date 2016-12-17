package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Customer;
import biz.LoginService;
import biz.impl.LoginServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getContextPath();
		String loginid = request.getParameter("userid");
		String password = request.getParameter("password");
		String isConfirm = request.getParameter("isConfirm");
		LoginService loginService = new LoginServiceImpl();
		boolean result = loginService.checkUser(loginid, password);
		Customer cust = loginService.getCustomer(loginid);
		if (result) {
			if (isConfirm.equals("ok")) {
				request.getSession().setAttribute("cust", cust);
				request.getRequestDispatcher("confirm.jsp").forward(request,
						response);

			} else {
				request.getSession().setAttribute("cust", cust);
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			}
		} else {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
