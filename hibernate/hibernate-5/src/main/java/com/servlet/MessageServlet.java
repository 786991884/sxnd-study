package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.HibernateUtils;
import com.model.TbMessage;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("list".equals(action)) {
			listMessage(request, response);
		} else if ("update".equals(action)) {
			updateMessage(request, response);
		} else if ("getMessage".equals(action)) {
			getMessage(request, response);
		}
	}

	// 获取全部留言信息
	public void listMessage(HttpServletRequest request,
							HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		HibernateUtils hibernateUtils = new HibernateUtils();
		List<TbMessage> listMessage = hibernateUtils.listMessage();// 获取全部留言信息
		request.setAttribute("listMessage", listMessage);// 保存留言信息到request中
		request.getRequestDispatcher("listMessage.jsp").forward(request,
				response);
	}

	// 获取指定留言信息
	public void getMessage(HttpServletRequest request,
						   HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		int id = Integer.parseInt(request.getParameter("id"));// 获取要查询的留言ID
		HibernateUtils hibernateUtil = new HibernateUtils();
		TbMessage message = hibernateUtil.getMessage(id);// 获取指定留言信息
		request.setAttribute("tbMessage", message); // 保存留言信息到request中
		request.getRequestDispatcher("showMessage.jsp").forward(request,
				response);
	}

	public void updateMessage(HttpServletRequest request,
							  HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));// 获取留言ID
		String writer = new String(request.getParameter("writer").getBytes(
				"ISO-8859-1"), "utf-8");// 获取留言人
		String content = new String(request.getParameter("content").getBytes(
				"ISO-8859-1"), "utf-8");// 获取留言内容
		HibernateUtils hibernateUtil = new HibernateUtils();
		TbMessage message = new TbMessage(); // 实例化对象
		message.setId(id); // 设置留言ID
		message.setWriter(writer); // 设置留言人属性的值
		message.setContent(content);// 设置留言内容属性的值
		String returnStr = hibernateUtil.updateMessage(message);// 更新留言信息
		// 弹出提示信息并重定向页面
		PrintWriter out = response.getWriter();
		out.print("<script>alert('" + returnStr
				+ "');window.location.href='forward.jsp';</script>");
		out.flush();
		out.close();
	}
}
