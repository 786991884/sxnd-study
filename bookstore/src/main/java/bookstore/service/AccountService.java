package bookstore.service;

import bookstore.dao.AccountDao;
import bookstore.dao.impl.AccountDaoImpl;
import bookstore.domain.Account;

public class AccountService {
	private AccountDao accountDao = new AccountDaoImpl();

	public Account getAccount(int accountId) {
		return accountDao.get(accountId);
	}
}
