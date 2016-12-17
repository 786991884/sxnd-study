package servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String defaultName;
	String defaultGreeting;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		if ((defaultName = config.getInitParameter("name")) == null) {
			defaultName = "Java";
		}
		if ((defaultName = config.getInitParameter("message")) == null) {
			defaultGreeting = "Hello World";
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>Init Example</title></head>");
		out.println("<body><h1>");
		out.println(defaultName + " " + defaultGreeting + " !");
		out.println("</h1></body></html>");
	}

}
