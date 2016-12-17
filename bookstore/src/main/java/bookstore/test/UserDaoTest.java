package bookstore.test;

import org.junit.Test;

import bookstore.dao.UserDao;
import bookstore.dao.impl.UserDaoImpl;
import bookstore.domain.User;

public class UserDaoTest {
	private UserDao userDao = new UserDaoImpl();

	@Test
	public void test() {
		User user = userDao.getUser("aaa");
		System.out.println(user);
	}

}
