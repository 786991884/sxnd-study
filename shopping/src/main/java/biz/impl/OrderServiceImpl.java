package biz.impl;

import biz.OrderService;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import entity.Order;
import entity.OrderDetail;

public class OrderServiceImpl implements OrderService {
	/**
	 * 保存订单信息
	 * 
	 * @param order
	 * @return
	 */
	public String saveOrder(Order order) {
		OrderDao orderDao = new OrderDaoImpl();
		String orderno = orderDao.saveOrder(order);
		return orderno;
	}

	/**
	 * 保存订单详情
	 * 
	 * @param detail
	 * @return
	 */
	public Boolean saveOrderDetial(OrderDetail detail) {
		OrderDao orderDao = new OrderDaoImpl();
		boolean result = orderDao.saveOrderDetial(detail);
		return result;
	}

	/**
	 * 得到客户编号
	 * 
	 * @return
	 */
	public String getOrderno() {
		int orderno = 1001;
		String orderNum = String.valueOf(orderno);
		return orderNum;
	}

	@Override
	public boolean changeStatus(String orderno) {
		OrderDao orderDao = new OrderDaoImpl();
		boolean result = orderDao.changeStatus(orderno);
		return result;
	}
}
