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

import com.hibernate.HibernateInitialize;

/**
 * Servlet implementation class QueryEmployee
 */

/**
 * 模糊查询员工信息
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
		String name = request.getParameter("name");
		Session session = null;// 实例化session对象
		try {
			session = HibernateInitialize.getSession();// 获得session对象
			String hql = "from Employee emp where emp.name like ?";// 查询HQL语句
			Query q = session.createQuery(hql);// 执行查询操作
			q.setParameter(0, "%" + name + "%");// 为模糊查询的参数赋值
			emplist = q.list();// 将返回的对象转化为List集合
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateInitialize.closeSession();// 关闭session
		}
		request.setAttribute("emplist", emplist);
		// 跳转到员工信息的列表页面
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
				"/employee.jsp");
		rd.forward(request, response);
	}
}
