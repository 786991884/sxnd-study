package bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.domain.User;
import bookstore.service.UserService;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		// 获取username请求参数的值
		String username = request.getParameter("username");
		// 调用UserService的getUser(username)获取user对象：要求trade是被装配好的，而且每一个trade对象的items也被装配好
		User user = userService.getUserWithTrades(username);
		// 把user对象放入到request中
		if (user == null) {
			response.sendRedirect(request.getServletPath() + "/error-1.jsp");
			return;
		}
		request.setAttribute("user", user);
		// 转发页面到/WEB-INF/page/trades.jsp
		request.getRequestDispatcher("/WEB-INF/pages/trades.jsp").forward(
				request, response);
	}
}
