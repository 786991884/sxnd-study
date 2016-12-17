package bank.biz;

import java.util.Collection;

import bank.dao.BankAccountDao;
import bank.entity.BankAccount;

/*
 * 业务实现
 */
public class BankBizImpl implements BankBiz {
	private BankAccountDao dao;

	public BankBizImpl() {
	}

	public BankBizImpl(BankAccountDao dao) {
		this.dao = dao;
	}

	public void setDao(BankAccountDao dao) {
		this.dao = dao;
	}

	public BankAccountDao getDao() {
		return dao;
	}

	@Override
	// 开户
	public BankAccount open(String name, float balance) {
		BankAccount ba = new BankAccount();
		ba.setName(name);
		ba.setBalance(balance);
		return dao.newBankAccount(ba);
	}

	@Override
	// 存款
	public BankAccount deposit(long accno, float amt) {
		BankAccount bank = dao.findAccountByAccno(accno);
		if (bank == null) {
			System.out.println("账号不存在，请重新输入账号！");
			return null;
		}
		BankAccount ba = new BankAccount();
		ba.setAccno(accno);
		return dao.deposit(ba, amt);
	}

	@Override
	// 取款
	public BankAccount withdraw(long accno, float amt) {
		// 判断账号是否存在
		BankAccount bank = dao.findAccountByAccno(accno);
		if (bank == null) {
			System.out.println("账号不存在，请重新输入账号");
			return null;
		}
		// 判断余额是否足够
		if (bank.getBalance() < amt) {
			System.out.println("余额不足，请重新输入");
			return null;
		}
		BankAccount ba = new BankAccount();
		ba.setAccno(accno);
		return dao.withdraw(ba, amt);
	}

	@Override
	// 转账
	public BankAccount transfer(long from, long to, float amt) {
		BankAccount bankfrom = dao.findAccountByAccno(from);
		if (bankfrom == null) {
			System.out.println("转出账户不存在，请重新输入!");
			return null;
		}
		// 判断余额是否足够
		if (bankfrom.getBalance() < amt) {
			System.out.println("余额不足，请重新输入!");
			return null;
		}

		BankAccount bankto = dao.findAccountByAccno(from);
		if (bankto == null) {
			System.out.println("转入账户不存在，请重新输入!");
			return null;
		}
		return dao.transfer(bankfrom, bankto, amt);
	}

	@Override
	// 返回所有账户信息
	public Collection<BankAccount> getAllAccounts() {
		return dao.getAllAccount();
	}

}
