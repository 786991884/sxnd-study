package servlet03;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifeCycle() {
		super();
		System.out.println("LifeCycle()......");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy()......");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doDelete(req, resp);
		System.out.println("doDelete()......");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()......");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()......");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPut(req, resp);
		System.out.println("doPut()......");
	}

	@Override
	public String getServletInfo() {
		return "This is my default servlet created by Eclipse";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()......");
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()......");
		if (request.getMethod().equalsIgnoreCase("post")) {
			doPost(request, response);
		} else if (request.getMethod().equalsIgnoreCase("get")) {
			doGet(request, response);
		} else {
			doPost(request, response);
		}
	}
}
