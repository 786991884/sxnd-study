package listener07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestListenerServlet")
public class TestListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("this is info return from TestListenerServlet");
		request.setAttribute("message", "good");// 设置request属性
		request.setAttribute("message", "better");// 替换request属性
		request.removeAttribute("message");// 删除request属性
		HttpSession session = request.getSession();// 创建session
		System.out.println("sessionid=" + session.getId());
		session.invalidate();// 销毁session
		out.close();
	}

}
