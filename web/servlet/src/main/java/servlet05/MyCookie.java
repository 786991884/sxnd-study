package servlet05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyCookie")
public class MyCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyCookie() {
		super();
	}

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// write Cookie
		Cookie cookie = new Cookie("MyName", "MyValue");
		// 设置Cookie的存活时间为30分钟
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
		// read cookie
		Cookie[] allCookie = request.getCookies();
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print(" Cookie write OK! <br>");
		out.print(" your exist all cookie <br>");
		if (allCookie != null && allCookie.length > 0) {
			for (Cookie c : allCookie) {
				out.print(c.getName() + " =" + c.getValue() + "<br>");
			}
		}
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
