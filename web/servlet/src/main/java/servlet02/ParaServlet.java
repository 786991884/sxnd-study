package servlet02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParaServlet")
public class ParaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			ServletContext sc = getServletContext();
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>Hello World</title></head>");
			out.println("<body>");
			Enumeration er = sc.getAttributeNames();
			while (er.hasMoreElements()) {
				out.println(er.nextElement().toString());
			}
			out.println("<h1>Hello World</h1>");
			out.println(request.getContentLength());
			out.println(request.getParameter("fname"));
			out.println(request.getParameter("lname"));
			out.println("</body></html>");
			out.close();
		} catch (IOException e) {
			getServletContext().log("Error in Helloworld", e);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("post")) {
			doPost(request, response);
		} else if (request.getMethod().equalsIgnoreCase("get")) {
			doGet(request, response);
		} else {
			doPost(request, response);
		}
	}

}
