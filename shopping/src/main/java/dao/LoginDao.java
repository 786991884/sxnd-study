package dao;

import entity.Customer;

public interface LoginDao {

	boolean checkUser(String loginid, String password);

	Customer getCustomer(String loginid);

	boolean register(Customer cust);

	boolean update(Customer cust);

}
