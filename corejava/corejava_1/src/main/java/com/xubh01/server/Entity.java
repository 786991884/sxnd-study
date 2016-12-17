package com.xubh01.server;
/*  
 <servlet>
	 	<servlet-name>login</servlet-name>
	 	<servlet-class>com.xubh02.server.demo4.LoginServlet</servlet-class>
	 </servlet> 
 */
public class Entity {
	private String name;
	private String clz;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClz() {
		return clz;
	}
	public void setClz(String clz) {
		this.clz = clz;
	}
	
}
