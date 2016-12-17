package com.xubh02.set;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
/**
 * 使用自定义类型 接收签名:从界面上接收 到会人员的名单 放入 HashSet中
 点名:遍历输出名单

 * @author Administrator
 *
 */
public class SetDemo04 {
	private Scanner sc ;
	private Set<Member> members;
	SetDemo04(){
		sc = new Scanner(System.in);
		members= new HashSet<Member>();
	}
	public String getStringFromConsole(){
		return sc.nextLine();
	}

	//签名:
	public void addMemeber(Member mem){
		members.add(mem);
	}
	//点名:遍历输出名单
	public void showMemeber(){
		Iterator<Member> it = members.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	public static void main(String[] args) {
		SetDemo04 demo = new SetDemo04();
		System.out.println("====签名======");
		while(true){
			String name =demo.getStringFromConsole();
			if(name.equalsIgnoreCase("over")){
				break;
			}
			Member m =new Member(name);
			demo.addMemeber(m);
		}
		System.out.println("=========参会人员有====");
		demo.showMemeber();

	}

}


class Member{
	private String name;
	private Date attendTime;
	public Member() {
		attendTime = new Date();
	}

	public Member(String name) {
		this();
		this.name = name;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getAttendTime() {
		return attendTime;
	}
	public void setAttendTime(Date attendTime) {
		this.attendTime = attendTime;
	}





	public Member(String name, Date attendTime) {
		super();
		this.name = name;
		this.attendTime = attendTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "名单:"+name+",签名时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(attendTime);
	}


}
