package biz;

import entity.Order;
import entity.OrderDetail;

public interface OrderService {
	// 保存订单信息
	String saveOrder(Order order);

	// 保存订单详情

	Boolean saveOrderDetial(OrderDetail detail);

	// 得到客户编号
	boolean changeStatus(String orderno);

}
