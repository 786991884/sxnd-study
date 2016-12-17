package bookstore.test;

import org.junit.Test;

import bookstore.dao.AccountDao;
import bookstore.dao.impl.AccountDaoImpl;
import bookstore.domain.Account;

public class AccountDAOTest {
	AccountDao accountDao = new AccountDaoImpl();

	@Test
	public void testGet() {
		Account account = accountDao.get(1);
		System.out.println(account.getBalance());
	}

	@Test
	public void testUpdateBalance() {
		accountDao.updateBalance(1, 50);
	}

}
