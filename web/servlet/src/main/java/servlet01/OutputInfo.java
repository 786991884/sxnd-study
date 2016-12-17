package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/outputInfo")
public class OutputInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Info page</title></head>");
		out.println("<body><center>");
		out.println("<p>其他信息:");
		out.println("客户端的IP地址：" + request.getRemoteAddr());
		out.println("客户端的端口号：" + request.getRemotePort());
		out.println("服务端的IP地址：" + request.getLocalAddr());
		out.println("服务端的端口号：" + request.getLocalPort());
		out.println("</p>");
		out.println("</center><body></html>");
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
