package ognldemo.test;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognldemo.User;

import org.junit.Test;

public class OGNLSetTest {
	@Test
	public void testOgnl06() throws Exception {
		User user = new User();

		// 调用setValue()方法来进行赋值
		// 第一个参数：OGNL表达式
		// 第二个参数：root对象
		// 第三个参数：要赋的值
		Ognl.setValue("userName", user, "张三");
		System.out.println(user.getUserName());

	}

	@Test
	public void testOgnl07() throws Exception {
		User user = new User();

		Map context = new HashMap();
		context.put("u", user);

		// 调用setValue()方法来进行赋值
		// 第一个参数：OGNL表达式
		// 第二个参数：context对象
		// 第三个参数：root对象
		// 第四个参数：要赋的值
		Ognl.setValue("#u.userName", context, new Object(), "张三");

		System.out.println(user.getUserName());
	}

	@Test
	public void testOgnl08() throws Exception {
		User user = new User();

		Map context = new HashMap();
		context.put("u", user);

		// 利用赋值符号"="来进行赋值
		Ognl.getValue("#u.username = '李四'", context, new Object());

		System.out.println(user.getUserName());
	}

	@Test
	public void testOgnl09() throws Exception {
		User user1 = new User();
		User user2 = new User();
		Map context = new HashMap();
		context.put("u1", user1);
		context.put("u2", user2);

		// 在一个表达式中可以用逗号分隔，同时执行多个表达式
		Ognl.getValue("#u1.userName = '李四',#u2.userName='王五'", context,
				new Object());

		System.out.println(user1.getUserName());
		System.out.println(user2.getUserName());
	}

}
