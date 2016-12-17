package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.impl.LoginServiceImpl;
import entity.Customer;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Customer cust = new Customer();
		LoginServiceImpl loginService = new LoginServiceImpl();
		String path = request.getContextPath();
		String type = request.getParameter("type");
		cust.setLoginid(request.getParameter("email"));
		cust.setTel(request.getParameter("phone"));
		cust.setCustname(request.getParameter("username"));
		cust.setPassword(request.getParameter("password"));
		cust.setAddress(request.getParameter("address"));
		cust.setGender(request.getParameter("gender"));

		if (type.equals("register")) {
			boolean result = loginService.register(cust);
			if (result) {
				request.getSession().setAttribute("cust", cust);
				request.getRequestDispatcher("/userinfo.jsp").forward(request,
						response);
			}

		} else {
			boolean result1 = loginService.update(cust);
			request.getSession().setAttribute("cust", cust);
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
