package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class QueryPeople
 */
/**
 * HQL左连接查询
 */
@WebServlet("/QueryPeople")
public class QueryPeople extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryPeople() {
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
		Session session = null;// 实例化session对象
		List<Object[]> list = new ArrayList<>();
		try {
			session = HibernateInitialize.getSession();// 获得session对象
			// 开启事物
			session.beginTransaction();
			String hql = "select peo.id,peo.name,peo.age,peo.sex,c.idcard_code from People peo left join peo.idcard c";// 条件查询HQL语句
			Query q = session.createQuery(hql);// 执行查询操作
			list = q.list();
			// 提交事物
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// 出错将回滚事物
			session.getTransaction().rollback();
		} finally {
			HibernateInitialize.closeSession();// 关闭session
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("index12.jsp").forward(request, response);
	}

}
