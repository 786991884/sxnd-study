package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.OrderService;
import biz.impl.OrderServiceImpl;
import entity.Customer;
import entity.Order;
import entity.OrderDetail;
import entity.Product;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String consignee = request.getParameter("consignee");
		String orderaddress = request.getParameter("orderaddress");
		String zipcode = request.getParameter("zipcode");
		String phone = request.getParameter("phone");
		String orderprice = request.getParameter("orderprice");
		Customer cust = new Customer();
		String custname = cust.getCustname();
		Order order = new Order();
		order.setCustomer(custname);
		order.setConsignee(consignee);
		order.setOrderprice(Double.parseDouble(orderprice));
		order.setZipcode(zipcode);
		order.setPhone(phone);
		order.setOrderaddress(orderaddress);
		OrderService oderServic = new OrderServiceImpl();
		// 返回订单编号
		String orderno = oderServic.saveOrder(order);
		int count = (int) session.getAttribute("count");
		List prodList = (List) session.getAttribute("prodList");
		List indexList = (List) session.getAttribute("indexs");
		List money = (List) session.getAttribute("orderprice");
		Product prodid = null;
		boolean res = false;
		double p = 0;
		for (int i = 0; i < prodList.size(); i++) {
			prodid = (Product) prodList.get(i);
			int input = (int) indexList.get(i);
			double moneys = (double) money.get(i);
			OrderDetail detail = new OrderDetail();
			detail.setOrder(order);
			detail.setMoney(moneys);
			detail.setCount(input);
			detail.setProduct(prodid);
			res = oderServic.saveOrderDetial(detail);
		}
		if (res) {
			boolean res2 = oderServic.changeStatus(orderno);
			request.getRequestDispatcher("success.jsp").forward(request,
					response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
