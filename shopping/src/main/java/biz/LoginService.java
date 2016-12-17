package biz;

import entity.Customer;

public interface LoginService {
	// 登陆验证
	public boolean checkUser(String loginid, String password);

	public Customer getCustomer(String loginid);

	// 用户验证
	public boolean register(Customer cust);

	// 得到客户编号
	public String getCustno();

	public boolean update(Customer cust);
}
