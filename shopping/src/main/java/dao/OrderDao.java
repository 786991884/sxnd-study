package dao;

import entity.Order;
import entity.OrderDetail;

public interface OrderDao {

	String saveOrder(Order order);

	boolean saveOrderDetial(OrderDetail detail);

	boolean changeStatus(String orderno);

}
