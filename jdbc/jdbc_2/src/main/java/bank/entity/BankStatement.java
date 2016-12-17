package bank.entity;

import java.sql.Date;

public class BankStatement {
	private long id;
	private String action;
	private Date txDate;
	private float amt;
	private BankAccount account; // 起始账户
	private BankAccount toaccount; // 目标账户，转账

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getTxDate() {
		return txDate;
	}

	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

	public float getAmt() {
		return amt;
	}

	public void setAmt(float amt) {
		this.amt = amt;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public BankAccount getToaccount() {
		return toaccount;
	}

	public void setToaccount(BankAccount toaccount) {
		this.toaccount = toaccount;
	}

}
