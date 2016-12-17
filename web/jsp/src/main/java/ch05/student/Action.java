package ch05.student;

import java.io.Serializable;

public class Action implements Serializable {

	private static final long serialVersionUID = 1L;
	private String action;
	private String resource;

	public Action() {
	}

	public Action(String action, String resource) {
		super();
		this.action = action;
		this.resource = resource;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
}
