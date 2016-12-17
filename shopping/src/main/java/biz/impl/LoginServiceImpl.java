package biz.impl;

import biz.LoginService;
import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import entity.Customer;

public class LoginServiceImpl implements LoginService {
	// 验证用户名和密码，返回一个布尔值
	public boolean checkUser(String loginid, String password) {
		LoginDao loginDao = new LoginDaoImpl();
		boolean result = loginDao.checkUser(loginid, password);
		return result;
	}

	// 得到Customer，保存到session中
	public Customer getCustomer(String loginid) {
		LoginDao loginDao = new LoginDaoImpl();
		Customer cust = loginDao.getCustomer(loginid);
		return cust;
	}

	// 用户注册
	public boolean register(Customer cust) {
		LoginDao loginDao = new LoginDaoImpl();

		boolean result = loginDao.register(cust);

		return result;
	}

	// 得到客户编号
	public String getCustno() {
		LoginDao loginDao = new LoginDaoImpl();
		int custno = 1001;

		String custNum = String.valueOf(custno);
		// custNum = loginDao.getCustno();
		return custNum;
	}

	// 完美用户信息
	public boolean update(Customer cust) {

		LoginDao loginDao = new LoginDaoImpl();
		boolean result = loginDao.update(cust);
		return result;
	}

}
