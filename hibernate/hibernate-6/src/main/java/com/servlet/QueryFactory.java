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

import org.hibernate.Session;

import com.hibernate.HibernateInitialize;

/**
 * Servlet implementation class QueryFactory
 */
/**
 * 查找生产商
 */
@WebServlet("/QueryFactory")
public class QueryFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryFactory() {
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
		Session session = null; // 声明一个Session对象
		List list = new ArrayList();// List集合
		try {
			// Hibernate的持久化操作
			session = HibernateInitialize.getSession();// 获取Session
			String hql = "from Factory";// 定义HQL语句
			session.beginTransaction();// 事务开启
			list = session.createQuery(hql).list();
			session.getTransaction().commit();// 事务提交
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();// 事务回滚
		} finally {
			HibernateInitialize.closeSession();// 关闭Session
		}
		request.setAttribute("list", list);// 保存查询返回的集合
		// 跳转到产品添加页面
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(
				"/AddProduct.jsp");
		rd.forward(request, response);
	}
}
