package oracle.wdp.struts2.action;

import java.util.ArrayList;
import java.util.List;

import oracle.wdp.struts2.model.Person;
import oracle.wdp.struts2.model.State;

import com.opensymphony.xwork2.ActionSupport;

public class EditPersonAction extends ActionSupport {
	private Person personBean;
	// 我们要给用户提供体育选项
	private String[] sports = { "football", "baseball", "basketball" };
	private String[] genders = { "male", "female", "not sure" };
	private List<State> states;
	private String[] carModelAvailable = { "Ford", "Chrysler", "Toyota",
			"Nissan" };

	public List<State> getStates() {
		states = new ArrayList<>();
		states.add(new State("AZ", "Arizona"));
		states.add(new State("CA", "California"));
		states.add(new State("FL", "Florida"));
		states.add(new State("KS", "Kansas"));
		states.add(new State("NY", "New York"));
		return states;
	}

	public String[] getCarModelAvailable() {
		return carModelAvailable;
	}

	public Person getPersonBean() {
		return personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}

	public String[] getSports() {
		return sports;
	}

	public String[] getGenders() {
		return genders;
	}

	public String doEdit() {
		return SUCCESS;
	}
}
