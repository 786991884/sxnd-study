package day07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FXTest {
	public static void main(String[] args) {
		// 无泛型创建链表对象
		List list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		// 获取链表迭代器
		Iterator it = list1.iterator();
		while (it.hasNext()) {
			// 获取元素类型为object,类型转换
			Object obj = it.next();
			String val = (String) obj;
			System.out.println(val);
		}
		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		// 用foreach进行遍历，类型直接转换为string
		for (String str : list2) {
			System.out.println(str);
		}
	}
}
