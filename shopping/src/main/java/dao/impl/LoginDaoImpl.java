package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtils;
import dao.LoginDao;
import entity.Customer;

public class LoginDaoImpl implements LoginDao {
	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet rs = null;

	@Override
	public boolean checkUser(String loginid, String password) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select loginid,password from customer where loginid=? and password=?";
			pt = conn.prepareStatement(sql);
			pt.setString(1, loginid);
			pt.setString(2, password);
			rs = pt.executeQuery();
			if (rs.next()) {
				if (rs.getString("loginid").equals(loginid)
						&& rs.getString("password").equals(password)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, pt, conn);
		}
		return false;
	}

	@Override
	public Customer getCustomer(String loginid) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from customer where loginid=?";
			pt = conn.prepareStatement(sql);
			pt.setString(1, loginid);
			rs = pt.executeQuery();
			if (rs.next()) {
				Customer cust = new Customer();
				cust.setAddress(rs.getString("address"));
				cust.setCustname(rs.getString("custname"));
				cust.setCustno(rs.getString("custno"));
				cust.setGender(rs.getString("gender"));
				cust.setIntegral(rs.getInt("numbergral"));
				cust.setLoginid(rs.getString("loginid"));
				cust.setPassword(rs.getString("password"));
				cust.setTel(rs.getString("tel"));
				return cust;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, pt, conn);
		}
		return null;
	}

	@Override
	public boolean register(Customer cust) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into customer(custno,loginid,password,tel) values(seq.nextval,?,?,?)";

			pt = conn.prepareStatement(sql);
			pt.setString(1, cust.getLoginid());
			pt.setString(2, cust.getPassword());
			pt.setString(3, cust.getTel());
			int res = pt.executeUpdate();
			if (res == 1) {
				rs = pt.executeQuery();
				if (rs.next()) {
					System.out.println(rs.getString("custno") + ""
							+ rs.getString("loginid"));
				}
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
	public boolean update(Customer cust) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update customer set custname=?,gender=?,address=? where custno=?";
			pt = conn.prepareStatement(sql);
			pt.setString(1, cust.getCustname());
			pt.setString(2, cust.getGender());
			pt.setString(3, cust.getAddress());
			pt.setString(4, cust.getCustno());
			int res = pt.executeUpdate();
			if (res == 1) {
				System.out.println(res);
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