package oracle.wdp.struts2.model;

import java.io.Serializable;

public class Person implements Serializable {
	public Person() {
	}

	private String firstName;
	private String lastName;
	private String sport;
	private String gender;
	private String residency;
	private boolean over21;
	private String carModels;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getResidency() {
		return residency;
	}

	public void setResidency(String residency) {
		this.residency = residency;
	}

	public boolean isOver21() {
		return over21;
	}

	public void setOver21(boolean over21) {
		this.over21 = over21;
	}

	public String getCarModels() {
		return carModels;
	}

	public void setCarModels(String carModels) {
		this.carModels = carModels;
	}
}
