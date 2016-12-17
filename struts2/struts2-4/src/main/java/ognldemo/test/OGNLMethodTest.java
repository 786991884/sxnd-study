package ognldemo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ognl.Ognl;
import ognldemo.User;

import org.junit.Test;

public class OGNLMethodTest {
	@Test
	public void testOgnl10() throws Exception {
		User user = new User();

		// 如果是调用root对象的方法，可以直接使用方法的名称来调用方法
		Integer value = (Integer) Ognl.getValue("addSomething(1,1)", user);
		System.out.println(value);
	}

	@Test
	public void testOgnl11() throws Exception {
		User user = new User();
		user.setUserName("李四");
		// 如果是调用root对象的方法，可以直接使用方法的名称来调用方法
		String value = (String) Ognl.getValue("getUserName()", user);
		System.out.println(value);
	}

	@Test
	public void testOgnl12() throws Exception {
		User user = new User();
		Ognl.getValue("setUserName('王五')", user);
		String value = (String) Ognl.getValue("getUserName()", user);
		System.out.println(value);
	}

	// OGNL调用静态方法和变量
	@Test
	public void testOgnl13() throws Exception {
		User user = new User();
		user.setUserName("王五");
		// 调用静态变量
		// 注意：out是System中的静态变量，out是PrintStream类型的一个对象
		// 而println()则是out这个对象中的实例方法（不是静态方法）
		// 调用静态方法，需要在类名和变量名前面加上@来调用，对于实例方法，用"."来调用
		// out是静态变量
		Ognl.getValue("@System@out.println(userName)", user);
	}

	@Test
	public void testOgnl14() throws Exception {

		Object root = new Object();
		Map context = new HashMap();

		// 利用OGNL创建java.util.List对象
		List list = (List) Ognl.getValue("{123,'xxx','kdjfk'}", context, root);
		context.put("list", list);

		// 利用OGNL创建数组
		int[] intarray = (int[]) Ognl.getValue("new int[]{23,45,67}", context,
				root);
		context.put("intarray", intarray);

		// 利用OGNL表达式创建java.util.Map对象
		Map mapvalue = (Map) Ognl.getValue(
				"#{'listvalue':#list,'intvalue':#intarray}", context, root);
		context.put("mapvalue", mapvalue);

		// 利用OGNL表达式访问这些数组和集合对象
		Ognl.getValue("@System@out.println(#list[1])", context, root);
		Ognl.getValue("@System@out.println(#intarray[2])", context, root);
		Ognl.getValue("@System@out.println(#mapvalue.listvalue[0])", context,
				root);
		Ognl.getValue("@System@out.println(#mapvalue['intvalue'][0])", context,
				root);
	}

	@Test
	public void testOgnl15() throws Exception {

		List root = new ArrayList();
		User user1 = new User();
		user1.setUserName("张三");
		User user2 = new User();
		user2.setUserName("李四");

		root.add(user1);
		root.add(user2);

		// 如果root对象是List类型
		System.out.println((Ognl.getValue("#root[0].userName", root)));
		System.out.println(Ognl.getValue("#root[1].userName", root));
	}

}
