package servlet06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestFilterServlet")
public class TestFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestFilterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>Test Filter Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println(request.getAttribute("name") + " : "
				+ request.getAttribute("str"));
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
