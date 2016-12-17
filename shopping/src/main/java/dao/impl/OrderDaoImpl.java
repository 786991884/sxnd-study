package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtils;
import dao.OrderDao;
import entity.Order;
import entity.OrderDetail;

public class OrderDaoImpl implements OrderDao {
	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet rs = null;

	@Override
	public String saveOrder(Order order) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into orderinfo( orderno,ordertime,consignee,orderprice,orderaddress,zipcode,phone,customer)values( seq.nextval,?,?,?,?,?,?,?)";
			pt = conn.prepareStatement(sql);
			java.util.Date date = new java.util.Date();
			pt.setDate(1,
					new Date(date.getYear(), date.getMonth(), date.getDate()));
			pt.setString(2, order.getConsignee());
			pt.setDouble(3, order.getOrderprice());
			pt.setString(4, order.getOrderaddress());
			pt.setString(5, order.getZipcode());
			pt.setString(6, order.getPhone());
			pt.setString(7, order.getCustomer());
			int result = pt.executeUpdate();
			if (result == 1) {
				pt = conn
						.prepareStatement("select*from orderinfo where consignee=?and phone=?");
				pt.setString(1, order.getConsignee());
				pt.setString(2, order.getPhone());
				rs = pt.executeQuery();
				if (rs.next()) {
					String orderno = rs.getString("orderno");
					return orderno;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, pt, conn);
		}
		return null;
	}

	@Override
	public boolean saveOrderDetial(OrderDetail detail) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into orderdetail(id,orderno,money,count,prodid)values(seq.nextval,?,?,?,?)";
			pt = conn.prepareStatement(sql);
			pt.setString(1, detail.getOrder().getOrderno());
			pt.setDouble(2, detail.getMoney());
			pt.setInt(3, detail.getCount());
			pt.setString(4, detail.getProduct().getProdid());
			int res = pt.executeUpdate();
			if (res == 1) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, pt, conn);
		}
		return false;
	}

	@Override
	public boolean changeStatus(String orderno) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update orderinfo set status=? where orderno=?";
			pt = conn.prepareStatement(sql);
			pt.setString(1, "已支付");
			pt.setString(2, orderno);
			int res = pt.executeUpdate();
			if (res == 1) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, pt, conn);
		}
		return false;
	}
}
