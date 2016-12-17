package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServiceServlet
 */
@WebServlet("/CustomerServiceServlet")
public class CustomerServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServiceServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String strName = request.getParameter("sName");
		System.out.println("客服人员编号：" + strName);
		int iRandom = (int) (Math.random() * 10);
		System.out.println("随机数：" + iRandom);
		if (iRandom % 2 == 1) {
			out.print("yes");
		} else {
			out.print("no");
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("test/html");
		PrintWriter out = response.getWriter();
		String strName = request.getParameter("sName");
		System.out.println("POST客服人员编号" + strName);

		int iRandom = (int) (Math.random() * 10);
		System.out.println("POST随机数" + iRandom);

		if (iRandom % 2 == 1) {
			out.print("yes");
		} else if (iRandom % 2 == 0) {
			out.print("no");
		}

		out.flush();
		out.close();
	}

}
