package bank.biz;

import java.util.Collection;

import bank.entity.BankAccount;

/*
 * 业务接口
 */
public interface BankBiz {
	BankAccount open(String name, float balance);// 开户

	BankAccount deposit(long accno, float amt);// 存款

	BankAccount withdraw(long accno, float amt);// 取款

	BankAccount transfer(long from, long to, float amt);// 转账

	Collection<BankAccount> getAllAccounts();// 返回所有账户信息
}
