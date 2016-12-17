package day07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyForeach {
	public static void main(String[] args) {
		MyList list = new MyList();
		list.getList().add("a");
		list.getList().add("b");
		list.getList().add("c");
		for (String s : list) {
			System.out.println(s);
		}
	}
}

// 自定义链表类
class MyList implements Iterable<String>, Iterator<String> {
	private int loc = 0;// 当前的下标
	private List<String> list = new ArrayList<>();

	@Override
	// 是否有下一个元素
	public boolean hasNext() {
		return list.size() > loc;
	}

	@Override
	// 得到下一个元素
	public String next() {
		return list.get(loc++);
	}

	@Override
	// 删除当前下标元素
	public void remove() {
		list.remove(loc);
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	// 得到迭代器
	public Iterator<String> iterator() {
		return this;
	}

}