package bookstore.dao.impl;

import bookstore.dao.AccountDao;
import bookstore.domain.Account;

public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {

	@Override
	public Account get(Integer accountId) {
		String sql = "SELECT accountId,balance FROM account WHERE accountId=?";
		return query(sql, accountId);
	}

	@Override
	public void updateBalance(Integer accountId, float amount) {
		String sql = "UPDATE account SET balance=balance-? WHERE accountId=?";
		update(sql, amount, accountId);
	}

}
