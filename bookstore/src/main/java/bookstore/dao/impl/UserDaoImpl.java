package bookstore.dao.impl;

import bookstore.dao.UserDao;
import bookstore.domain.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUser(String username) {
		String sql = "SELECT userId,username,accountId FROM userinfo WHERE username=?";
		return query(sql, username);
	}

}
