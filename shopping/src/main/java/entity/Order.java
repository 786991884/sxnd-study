package entity;

import java.util.Date;

public class Order {
	private String orderno ;
	private Date ordertime ;
	private String customer ;
	private String consignee;
	private double orderprice  ;
	private String orderaddress ;
	private String zipcode;
	private String phone;
	private String status  ;
	public Order() {
	}
	public Order(String orderno, Date ordertime, String customer,
			String consignee, double orderprice, String orderaddress,
			String status) {
		super();
		this.orderno = orderno;
		this.ordertime = ordertime;
		this.customer = customer;
		this.consignee = consignee;
		this.orderprice = orderprice;
		this.orderaddress = orderaddress;
		this.status = status;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public double getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}
	public String getOrderaddress() {
		return orderaddress;
	}
	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
