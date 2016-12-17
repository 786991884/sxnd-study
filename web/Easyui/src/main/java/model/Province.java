package model;

public class Province {
	
	private int id ;
	private String name ;
	
	
	public Province() {
		super();
	}


	public Province(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
