package bank.test;

import java.util.Collection;
import java.util.Scanner;

import bank.biz.BankBizImpl;
import bank.dao.BankAccountDao;
import bank.dao.BankAccountDaoImpl;
import bank.entity.BankAccount;

/*
 * 显示层，
 */
public class BankTest {
	public static void main(String args[]) {
		BankTest test = new BankTest();

		for (;;) {
			menu();
			switch (getNumber()) {
				case 1:
					test.open();
					break;
				case 2:
					test.deposit();
					break;
				case 3:
					test.withdraw();
					break;
				case 4:
					test.transfer();
					break;
				case 5:
					test.showInfo();
					break;
				case 6:
					println("程序结束！");
					System.exit(0);
					break;
			}
			println("\n\n\n****************************************\n\n");
		}

	}

	public static void print(String str) {
		System.out.print(str);
	}

	public static void println(String str) {
		System.out.println(str);
	}

	public static void printAccount(String str, BankAccount bank) {
		print(str);
		println("账户信息：");
		println("账户编号：" + bank.getAccno());
		println("账户名称：" + bank.getName());
		println("账户余额：" + bank.getBalance());
	}

	// 开户
	public void open() {
		Scanner in = new Scanner(System.in);
		print("请输入名称：");
		String name = in.next();
		print("请输入存款金额：");
		float balance = in.nextFloat();

		BankBizImpl bankBiz = new BankBizImpl();
		BankAccountDao dao = new BankAccountDaoImpl();
		bankBiz.setDao(dao);
		BankAccount bank = bankBiz.open(name, balance);
		printAccount("开户成功！", bank);
	}

	// 存款
	public void deposit() {
		Scanner in = new Scanner(System.in);
		print("请输入账号：");
		long accno = in.nextLong();
		print("请输入存款金额：");
		float balance = in.nextFloat();

		BankBizImpl bankBiz = new BankBizImpl();
		BankAccountDao dao = new BankAccountDaoImpl();
		bankBiz.setDao(dao);
		BankAccount bank = bankBiz.deposit(accno, balance);
		if (bank != null) {
			printAccount("存款成功！", bank);
		}
	}

	// 取款
	public void withdraw() {
		Scanner in = new Scanner(System.in);
		print("请输入账号：");
		long accno = in.nextLong();
		print("请输入取款金额：");
		float balance = in.nextFloat();

		BankBizImpl bankBiz = new BankBizImpl();
		BankAccountDao dao = new BankAccountDaoImpl();
		bankBiz.setDao(dao);
		BankAccount bank = bankBiz.withdraw(accno, balance);
		if (bank != null) {
			printAccount("取款成功！", bank);
		}
	}

	// 转账
	public void transfer() {
		Scanner in = new Scanner(System.in);
		print("请输入转出账号：");
		long fromaccno = in.nextLong();
		print("请输入转入账号：");
		long toaccno = in.nextLong();
		print("请输入转账金额：");
		float balance = in.nextFloat();
		BankBizImpl bankBiz = new BankBizImpl();
		BankAccountDao dao = new BankAccountDaoImpl();
		bankBiz.setDao(dao);
		BankAccount bank = bankBiz.transfer(fromaccno, toaccno, balance);
		if (bank != null) {
			printAccount("转账成功！", bank);
		}
	}

	// 显示所有账户信息
	public void showInfo() {
		BankBizImpl bankBiz = new BankBizImpl();
		BankAccountDao dao = new BankAccountDaoImpl();
		bankBiz.setDao(dao);
		Collection<BankAccount> bankInfo = bankBiz.getAllAccounts();
		println("账号\t姓名\t账户余额");
		for (BankAccount bank : bankInfo) {
			print(bank.getAccno() + "\t");
			print(bank.getName() + "\t");
			print(bank.getBalance() + "\n");
		}
	}

	public static void menu() {
		println("**********欢迎银行业务处理系统**********");
		println("1、开户");
		println("2、存款");
		println("3、取款");
		println("4、转账");
		println("5、显示所有账户信息");
		println("6、退出");
		print("请输入数字(1,2,3,4,5,6)选择菜单:");
	}

	public static int getNumber() {
		Scanner in = new Scanner(System.in);

		String str = in.next();
		while (!checkStr(str)) {
			println("输入错误！");
			menu();
			str = in.next();
		}

		return Integer.parseInt(str);
	}

	public static boolean checkStr(String str) {
		boolean flag = false;
		if (str.equals("1") | str.equals("2") | str.equals("3")
				| str.equals("4") | str.equals("5") | str.equals("6")) {
			flag = true;
		}

		return flag;
	}
}