package bank.entity;

import java.util.HashSet;
import java.util.Set;

public class BankAccount {
	private long accno;
	private String name;
	private float balance;
	private Set<BankStatement> statements = new HashSet<>();

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BankStatement> getStatements() {
		return statements;
	}

	public void setStatements(Set<BankStatement> statements) {
		this.statements = statements;
	}
}
