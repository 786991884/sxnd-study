package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.bean.Employee;
import com.hibernate.HibernateUtil;

/**
 * Servlet implementation class UpdateEmployee
 */
/**
 * 修改员工信息
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployee() {
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
		request.setCharacterEncoding("UTF-8");// 设置编码方式
		// 从页面取值
		Integer id = new Integer(request.getParameter("id"));// 获取唯一性标识
		String name = request.getParameter("name");// 获取员工姓名
		String sex = request.getParameter("sex");
		String business = request.getParameter("business");
		String address = request.getParameter("address");
		String remark = request.getParameter("remark");
		// 修改操作
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();//开启事务
			Employee employee=(Employee) session.load(Employee.class, id);//修改操作
			employee.setName(name);//修改员工的各个属性
			employee.setBusiness(business);
			employee.setSex(sex);
			employee.setBusiness(business);
			employee.setAddress(address);
			employee.setRemark(remark);
			session.getTransaction().commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();//事务回滚
		}finally{
			HibernateUtil.closeSession();//关闭session
		}
		//修改成功后跳转到查找的Servlet
		request.getRequestDispatcher("QueryEmployee")
				.forward(request, response);
	}

}
