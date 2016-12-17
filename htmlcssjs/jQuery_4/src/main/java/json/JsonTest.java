package json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {
	public static void main(String[] args) {
		// 将java对象转换成json字符串
		Person p = new Person("小强", "男", 20);
		System.out.println(JSONObject.fromObject(p));
		// 将json字符串转换成java对象
		String str = "{\"age\":20,\"name\":\"小强\",\"sex\":\"男\"}";
		JSONObject jsonObj = JSONObject.fromObject(str);
		Person p1 = (Person) JSONObject.toBean(jsonObj, Person.class);
		System.out.println(p1);
		// 将集合转换成json数组
		List<Person> ps = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			ps.add(new Person("p" + i, "男", 20 + i));
		}
		// 将json数组转换成集合
		String arr_str = "[{\"age\":20,\"name\":\"p0\",\"sex\":\"男\"},{\"age\":21,\"name\":\"p1\",\"sex\":\"男\"}]";
		JSONArray jsonArr = JSONArray.fromObject(arr_str);
		List<Person> ps1 = (List<Person>) JSONArray.toCollection(jsonArr,
				Person.class);
		for (Iterator iterator = ps1.iterator(); iterator.hasNext();) {
			Person person = (Person) iterator.next();
			System.out.println(person);
		}
	}
}
