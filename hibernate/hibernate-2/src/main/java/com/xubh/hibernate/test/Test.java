package com.xubh.hibernate.test;

import java.util.Date;

import com.xubh.hibernate.entity.Name;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xubh.hibernate.entity.User;
import com.xubh.hibernate.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			// 添加
			Name name = new Name();
			name.setFirstName("Avla");
			name.setLastName("wu");
			User user = new User();
			user.setName(name);
			user.setBirthday(new Date());
			session.save(user);
			// 查询
			User user1 = (User) session.get(User.class, 1);
			System.out.println(user1.getName().getFirstName() + ""
					+ user.getName().getLastName());
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();
			}
		}
	}
}
