package bookstore.dao;

import bookstore.domain.Account;

public interface AccountDao {
	/**
	 * 根据 accountId 获取对应的 Account 对象
	 *
	 * @param accountId
	 * @return
	 */
	Account get(Integer accountId);

	/**
	 * 根据传入的accountId,amount更新指定账户的余额：扣除amount指定的钱数
	 *
	 * @param accountId
	 * @param amount
	 */
	void updateBalance(Integer accountId, float amount);
}
