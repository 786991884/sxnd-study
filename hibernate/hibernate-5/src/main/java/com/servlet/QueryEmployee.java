package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.HibernateUtil;

/**
 * Servlet implementation class QueryEmployee
 */
/**
 * 查找员工信息列表
 */
@WebServlet("/QueryEmployee")
public class QueryEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryEmployee() {
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
		request.setCharacterEncoding("UTF-8");
		List emplist = new ArrayList();// 实例化List信息集合
		Session session = null;// 实例化session对象
		try {
			session = HibernateUtil.getSession();// 获得session对象
			String hql = "from Employee emp";// 查询HQL语句
			Query q = session.createQuery(hql);// 执行查询操作
			emplist = q.list();// 将返回的对象转化为List集合
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();// 关闭session
		}
		request.setAttribute("emplist", emplist);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
				"/index.jsp");
		rd.forward(request, response);
	}
}
