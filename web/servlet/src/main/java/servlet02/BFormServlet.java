package servlet02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BFormServlet")
public class BFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		ServletInputStream in = request.getInputStream();
		ServletOutputStream out = response.getOutputStream();
		String select = request.getParameter("lname");
		System.out.println("lname=" + select);
		int contentLength = request.getContentLength();
		byte[] content = new byte[contentLength];
		int result;
		int totalRead = 0;
		result = in.read(content, 0, contentLength);
		while (result != -1) {
			totalRead += result;
			result = in.readLine(content, totalRead, contentLength);
			System.out.println(totalRead);
		}
		out.write(content, 0, totalRead);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
