package ognldemo;

public class User {
	private String userName;
	public String getUserName() {
		System.out.println("getUserName()");
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private Group group;
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
  public int addSomething(int a,int b){
	  return a+b;
  }
}
