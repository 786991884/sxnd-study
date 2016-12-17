package sxndjspnew;

import java.io.Serializable;

public class MyUser implements Serializable {
     private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MyUser() {
	}

}
