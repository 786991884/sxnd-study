package servlet02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML");
		out.println("  <HEAD><TITLE>servlet  API</TITLE>");
		out.println("<style type='text/css'>");
		out.println("body {");
		out.println("font: 12px Arial, Helvetica, sans-serif;");
		out.println("color: #000;");
		out.println("background-color: #EEF2FB;");
		out.println("margin: 0px;}");
		out.println(".table{border-collapse:collapse; font-size:13px; height:24px; line-height:24px; color:#09F; text-align:center;}");
		out.println(".table tr td{border:solid 1px #36F;}");
		out.println("</style>");
		out.println("</HEAD>");
		out.println("  <BODY>");
		System.out.println(request.getQueryString());
		out.println("request对象的常用方法<br>");
		out.println("<table align='center' width='850' border='0' class='table' cellpadding='0' cellspacing='0' >");
		out.println("<tr><td>ServletContext.log(msg) </td> <td>写到控制台</td></tr>");
		out.println("<tr><td>request.getParameter(String name)</td> <td>父类方法，得到指定参数名称的值</td></tr>");
		out.println("<tr><td>request.getParameterMap()</td> <td>父类方法，得到请求(参数名称=值)的一个Map</td></tr>");
		out.println("<tr><td>request.getRequestDispatcher(String path)</td> <td>得到一个请求转发对象(RequestDispatcher),调用它的forward或者include方法转发当前请求</td></tr>");
		out.println("<tr><td>request.getParameterNames()</td> <td>父类方法，得到当前请求所有参数名称,得到一个Enumeration</td></tr>");
		out.println("<tr><td>request.getParameterValues(String name) </td> <td>父类方法，得到相同名称的页面元素的值，如：复选框,得到一个String数组</td></tr>");
		out.println("<tr><td>request.getQueryString()  </td> <td>得到URL后面的所有参数，得到一个String类型的对象</td></tr>");
		out.println("<tr><td>request.getContextPath()</td> <td>得到工程路径:"
				+ request.getContextPath() + "</td></tr>");
		out.println("<tr><td>request.getSession().getId()</td> <td>通过request得到当前session ID:"
				+ request.getSession().getId() + "</td></tr>");
		out.println("<tr><td>request.getRequestURI()</td> <td>得到URL工程名后面部分:"
				+ request.getRequestURI() + "</td></tr>");
		out.println("<tr><td>request.getRequestURL()</td> <td>得到完整URL:"
				+ request.getRequestURL() + "</td></tr>");
		out.println("<tr><td>request.setAttribute(String name,Object o)</td> <td>给当前请求增加一个属性并付值o</td></tr>");
		out.println("<tr><td>request.getAttribute(String name)</td> <td>获得当前请求指定属性(name)的值</td></tr>");
		out.println("</table>");
		out.println("<br><br>response对象常用方法<br>");
		out.println("<table align='center' width='850' border='0' class='table' cellpadding='0' cellspacing='0' >");
		out.println("<tr><td>response.getWriter()</td> <td>获得一个PrintWriter</td></tr>");
		out.println("<tr><td>response.getLocale()</td> <td>获得客户端语言环境,你的当前语言环境是:"
				+ response.getLocale() + "</td></tr>");
		out.println("<tr><td>response.setLocale(Locale loc)</td><td>设置客户端的语言环境</td></tr>");
		out.println("<tr><td>response.setContentType(String type)</td><td>设置客户端的内容类型,比如：application/zip</td></tr>");
		out.println("<tr><td>response.sendRedirect(String location)</td><td>设置页面跳转到指定的URL,注意这里和request.getRequestDispatcher(String path)区别</td></tr>");
		out.println("</table>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
