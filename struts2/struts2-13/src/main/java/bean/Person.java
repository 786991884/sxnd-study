package bean;

import java.util.Map;

public class Person {
	private String name;
	private Address address;
	private Map<String, String> accounts;
	private int age;

	public Person(String name, int age, Address address,
			Map<String, String> accounts) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.accounts = accounts;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Map<String, String> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<String, String> accounts) {
		this.accounts = accounts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
