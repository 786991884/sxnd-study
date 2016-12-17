package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bean.Employee;
import com.hibernate.HibernateUtil;

/**
 * Servlet implementation class QueryOneEmployee
 */
/**
 * 修改时查询一个员工信息
 */
@WebServlet("/QueryOneEmployee")
public class QueryOneEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryOneEmployee() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer id=new Integer(request.getParameter("id"));
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Employee employeeVo=(Employee) session.get(Employee.class, id);//根据id查询信息
			request.setAttribute("employeeVo", employeeVo);
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();//关闭session
		}
		// 跳转到修改页面
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

}
