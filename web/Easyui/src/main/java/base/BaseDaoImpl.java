package base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtils;

/**
 * jdbc连接 ： 1创建连接对象 2拼sql 3 preparedstatemenet
 * 
 * @author _oiYc
 * 
 * @param <T>
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

	// public
	protected Class clazz;

	public BaseDaoImpl() {

		// System.out.println(this.getClass());
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 带有真实类型参数的对象
		clazz = (Class) pt.getActualTypeArguments()[0];
		System.out.println(clazz);
	}

	/**
	 * 保存方法
	 */
	public void save(T obj) throws Exception {

		// obj.getSimpleName();
		Connection conn = DBUtils.createConn();
		String sql = "insert into " + clazz.getSimpleName() + " values(null ";
		// 可以获取本类所声明的变量
		Field[] fs = clazz.getDeclaredFields();
		// System.out.println(fs.length);

		for (int i = 1; i < fs.length; i++) {
			sql += ",? ";
		}
		sql = sql + ")";
		System.out.println(sql);

		// 进行预编译
		PreparedStatement ps = DBUtils.getPs(conn, sql);

		// ps.setString(1, user.getName());

		for (int i = 1; i < fs.length; i++) {
			// 拼接方法的名称
			String MethodName = "get" + Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1);
			Method m = clazz.getMethod(MethodName);
			ps.setObject(i, m.invoke(obj));
		}
		ps.executeUpdate();
		DBUtils.close(ps);
		DBUtils.close(conn);

	}

	/**
	 * 更新方法
	 */
	public void update(T obj) throws Exception {

		Connection conn = DBUtils.createConn();
		// update user set name = ? , age = ? where id = ?
		String sql = " update " + clazz.getSimpleName() + " set  ";
		Field[] fs = clazz.getDeclaredFields();
		for (int i = 1; i < fs.length; i++) {
			sql += fs[i].getName() + "=?,";
		}
		sql = sql.substring(0, sql.length() - 1) + " where id = ? ";

		PreparedStatement ps = DBUtils.getPs(conn, sql);

		for (int i = 1; i < fs.length; i++) {
			String methodName = "get" + Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1);
			Method m = clazz.getMethod(methodName);
			ps.setObject(i, m.invoke(obj));// user.getName();
		}
		Method m2 = clazz.getMethod("getId");
		ps.setInt(fs.length, (Integer) m2.invoke(obj));

		ps.executeUpdate();
		DBUtils.close(ps);
		DBUtils.close(conn);

	}

	/**
	 * 根据一个id 查找对象
	 */
	public T findById(int id) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = " select * from  " + clazz.getSimpleName() + " where id = " + id;
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		T t = (T) clazz.newInstance();
		if (rs.next()) {
			Field[] fs = clazz.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {

				String methodName = "set" + Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1);
				Method m = clazz.getDeclaredMethod(methodName, fs[i].getType());
				m.invoke(t, rs.getObject(fs[i].getName()));
			}
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return t;
	}

	/**
	 * 查询所有
	 */
	public List<T> findAll() throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = " select * from " + clazz.getSimpleName();
		PreparedStatement ps = DBUtils.getPs(conn, sql);

		List<T> list = new ArrayList<T>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			T t = (T) clazz.newInstance();

			Field[] fs = clazz.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {
				String methodName = "set" + Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1);
				Method m = clazz.getMethod(methodName, fs[i].getType());
				m.invoke(t, rs.getObject(fs[i].getName()));
			}

			list.add(t);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list;
	}

	/**
	 * 删除方法
	 */
	public void delete(int id) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = " delete from " + clazz.getSimpleName() + " where id =" + id;
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ps.executeUpdate(sql);
		DBUtils.close(ps);
		DBUtils.close(conn);
	}

	/**
	 * 条件查询的反射封装方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> queryListForParams(String sql, Object[] params) throws Exception {
		Connection conn = DBUtils.createConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			// 建立statement对象(封装了sql)
			ps = conn.prepareStatement(sql); // select * from org where id = ?
												// and name = ? [1 , z3]
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			Field[] fs = clazz.getDeclaredFields();
			rs = ps.executeQuery();
			while (rs.next()) {
				Object obj = clazz.getConstructor().newInstance();
				for (int i = 0; i < fs.length; i++) {
					String methodName = "set" + fs[i].getName().substring(0, 1).toUpperCase() + fs[i].getName().substring(1);
					Method m = clazz.getMethod(methodName, fs[i].getType());
					Object value = rs.getObject(fs[i].getName());
					m.invoke(obj, value);
				}
				list.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs);
			DBUtils.close(ps);
			DBUtils.close(conn);
		}
		return list;
	}

}
