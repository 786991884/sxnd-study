package ognldemo.test;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;
import ognldemo.Group;
import ognldemo.Organization;
import ognldemo.User;

import org.junit.Test;

public class OGNLTest {
	@Test
	public void testOGNL1() throws OgnlException {
		User user = new User();
		user.setUserName("张三");
		System.out.println(user.getUserName());
		// 访问属性的表达式
		String userName = (String) Ognl.getValue("userName", user);
		System.out.println(userName);
	}

	@Test
	public void testOGNL2() throws OgnlException {
		User user = new User();
		Group g = new Group();
		Organization o = new Organization();
		o.setOrgId("ORGID");
		g.setOrg(o);
		user.setGroup(g);
		// 访问属性的表达式
		String orgID = (String) Ognl.getValue("group.org.orgId", user);
		System.out.println(orgID);
	}

	@Test
	public void testOGNL3() throws OgnlException {
		User user = new User();
		Group g = new Group();
		Organization o = new Organization();
		o.setOrgId("ORGID");
		g.setOrg(o);
		user.setGroup(g);

		// #代表从根开始，root是一个特殊值
		/*
		 * #root--->user#root.grounp--->user.getGroup
		 */

		String orgID = (String) Ognl.getValue("#root.group.org.orgId", user);
		System.out.println(orgID);
	}

	@Test
	public void testOGNL4() throws OgnlException {
		User user = new User();
		user.setUserName("张三");
		User user2 = new User();
		user2.setUserName("李四");

		Map context = new HashMap();
		context.put("u1", user);
		context.put("u2", user2);

		String msg = (String) Ognl.getValue("#u1.userName+ ',' +#u2.userName",
				context, new Object());
		System.out.println(msg);
	}

	@Test
	public void testOGNL5() throws OgnlException {
		User user = new User();
		user.setUserName("张三");

		User user2 = new User();
		user2.setUserName("李四");

		User user3 = new User();
		user3.setUserName("王五");

		Map context = new HashMap();
		context.put("u1", user);
		context.put("u2", user2);

		String msg = (String) Ognl.getValue(
				"#u1.userName+ ',' +#u2.userName+ ',' +userName", context,
				user3);
		System.out.println(msg);
	}
}
