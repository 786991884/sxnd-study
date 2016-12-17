package bookstore.dao;

import bookstore.domain.User;

public interface UserDao {
	/**
	 * 根据用户名获取User对象
	 *
	 * @param username
	 * @return
	 */
	User getUser(String username);
}
