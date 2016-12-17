package day07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
	public static void main(String[] args) {
		// 创建保存字符串的list对象
		List<String> list = new ArrayList<>();
		// 存入元素a和b
		list.add("a");
		list.add("b");
		// 得到list的迭代器
		Iterator<String> it = list.iterator();
		// 调用迭代器的hasNext()方法，判断是否有下一个元素
		while (it.hasNext()) {
			// 将迭代的下标移动一位，并得到当前位置的元素
			System.out.println(it.next());
		}
	}
}
