package day07;

import java.util.ArrayList;
import java.util.Vector;

public class ListTest {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();// 创建Vector对象
		v.add("hello");// 添加元素
		v.remove("hello");// 删除元素
		System.out.println(v.size());// 得到vector的元素数量
		// 创建一个arraylist对象
		ArrayList<String> al = new ArrayList<>();
		al.add("hello");
		al.remove("hello");
		// 得到链表中的元素数量
		System.out.println(al.size());
	}
}
