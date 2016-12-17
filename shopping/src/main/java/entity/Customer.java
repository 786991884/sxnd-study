package entity;

public class Customer {
	private String custno;
	private String loginid;
	private String password;
	private String custname;
	private String gender;
	private String tel;
	private String address;
	private int integral;

	public Customer() {
	}

	public Customer(String custno, String loginid, String password,
			String custname, String gender, String tel, String address,
			int integral) {
		super();
		this.custno = custno;
		this.loginid = loginid;
		this.password = password;
		this.custname = custname;
		this.gender = gender;
		this.tel = tel;
		this.address = address;
		this.integral = integral;
	}

	public String getCustno() {
		return custno;
	}

	public void setCustno(String custno) {
		this.custno = custno;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

}
