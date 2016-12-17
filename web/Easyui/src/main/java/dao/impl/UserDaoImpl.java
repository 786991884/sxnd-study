package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.User;
import util.DBUtils;
import base.BaseDaoImpl;
import dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public List<User> findByPagination(int currentPage, int pageSize,
			Map<String, Object> m) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = " select * from user  where 1=1 ";

		Set<Entry<String, Object>> set = m.entrySet();
		Iterator io = set.iterator();
		while (io.hasNext()) {
			Entry<String, Object> me = (Entry<String, Object>) io
					.next();
			if ("username".equals(me.getKey()) && !"".equals(me.getValue())) {
				sql += " and " + me.getKey() + " like '%" + me.getValue()
						+ "%'";
			}
			if ("startTime".equals(me.getKey()) && !"".equals(me.getValue())) {
				sql += " and " + me.getKey() + " >= '" + me.getValue() + "'";
			}
			if ("endTime".equals(me.getKey()) && !"".equals(me.getValue())) {
				sql += " and " + me.getKey() + " <= '" + me.getValue() + "'";
			}
			if ("sort".equals(me.getKey()) && !"".equals(me.getValue())) {
				sql += " order by " + me.getValue();
			}
			if ("order".equals(me.getKey()) && !"".equals(me.getValue())) {
				sql += " " + me.getValue();
			}
		}
		sql = sql + " limit " + (currentPage - 1) * pageSize + " , " + pageSize;
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();

		List<User> ulist = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setAge(rs.getInt("age"));
			user.setBirthday(rs.getString("birthday"));
			user.setCity(rs.getInt("city"));
			user.setSalary(rs.getString("salary"));
			user.setSex(rs.getString("sex"));
			user.setStartTime(rs.getString("startTime"));
			user.setEndTime(rs.getString("endTime"));
			user.setDescription(rs.getString("description"));

			ulist.add(user);
		}
		return ulist;
	}

	public int getTotal(Map<String, Object> m) throws Exception {

		Connection conn = DBUtils.createConn();
		String sql = " select count(*) from user  where 1=1 ";

		Set<Entry<String, Object>> set = m.entrySet();
		Iterator io = set.iterator();
		while (io.hasNext()) {
			Entry<String, Object> me = (Entry<String, Object>) io
					.next();
			if ("username".equals(me.getKey()) && !"".equals(me.getValue())) {
				sql += " and " + me.getKey() + " like '%" + me.getValue()
						+ "%'";
			}
			if ("startTime".equals(me.getKey()) && !"".equals(me.getValue())) {
				sql += " and " + me.getKey() + " >= '" + me.getValue() + "'";
			}
			if ("endTime".equals(me.getKey()) && !"".equals(me.getValue())) {
				sql += " and " + me.getKey() + " <= '" + me.getValue() + "'";
			}
			if ("sort".equals(me.getKey()) && !"".equals(me.getValue())) {
				sql += " order by " + me.getValue();
			}
			if ("order".equals(me.getKey()) && !"".equals(me.getValue())) {
				sql += " " + me.getValue();
			}
		}
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		int count = 0;
		if (rs.next()) {

			count = rs.getInt(1);
		}
		return count;
	}

	/**
	 *
	 */
	public List<User> searchByName(String q) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = " select * from user where username like '%" + q + "%'";
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<User> ulist = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setAge(rs.getInt("age"));
			user.setBirthday(rs.getString("birthday"));
			user.setCity(rs.getInt("city"));
			user.setSalary(rs.getString("salary"));
			user.setSex(rs.getString("sex"));
			user.setStartTime(rs.getString("startTime"));
			user.setEndTime(rs.getString("endTime"));
			user.setDescription(rs.getString("description"));
			ulist.add(user);
		}

		return ulist;
	}

	/*
	 * @Override public List<User> findByPagination(int currentPage, int
	 * pageSize) throws Exception { Connection conn = DBUtils.createConn();
	 * String sql = "select * from user limit " + (currentPage - 1) * pageSize +
	 * "," + pageSize; PreparedStatement ps = DBUtils.getPs(conn, sql);
	 * ResultSet rs = ps.executeQuery(); List<User> ulist = new
	 * ArrayList<User>(); while (rs.next()) { User user = new User();
	 * user.setId(rs.getInt("id")); user.setUsername(rs.getString("username"));
	 * user.setPassword(rs.getString("password"));
	 * user.setAge(rs.getInt("age"));
	 * user.setBirthday(rs.getString("birthday"));
	 * user.setCity(rs.getInt("city")); user.setSalary(rs.getString("salary"));
	 * user.setSex(rs.getString("sex"));
	 * user.setStartTime(rs.getString("startTime"));
	 * user.setEndTime(rs.getString("endTime"));
	 * user.setDescription(rs.getString("description")); ulist.add(user); }
	 * return ulist; }
	 */

	public int getTotal() throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select count(*) from user";
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

}
