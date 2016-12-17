package servlet02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurveyServlet
 */
@WebServlet("/SurveyServlet")
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SurveyServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		response.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		out.println("<html><title>display survey information</title><body>");
		out.println("<table>");
		Enumeration headNames = request.getParameterNames();
		while (headNames.hasMoreElements()) {
			out.println("<tr>");
			String name = headNames.nextElement().toString();
			out.println("<td>" + name + "</td><td>");
			String values[] =request.getParameterValues(name);
			
			for (int i = 0; i < values.length; i++) {
				out.println(new String(values[i].getBytes("iso-8859-1"),"utf-8")+ "<br>");
			}
			out.println("</td></tr>");
		}
		out.println("</table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
