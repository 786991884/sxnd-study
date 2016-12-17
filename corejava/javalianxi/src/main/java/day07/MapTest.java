package day07;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		// 创建map对象
		Map<String, String> map = new HashMap<>();
		// 存放对象
		map.put("a", "123");
		map.put("b", "456");
		map.put("c", "789");
		// 通过key的集合进行遍历
		for (String key : map.keySet()) {
			// 用get方法获取value
			System.out.println(key + ":" + map.get(key));
		}
	}
}
