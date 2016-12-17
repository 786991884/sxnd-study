package com.xubh.sxndhibernate.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xubh.sxndhibernate.entity.User;

public class Hibernate3State {

	public void insertUser() {
		User user = new User();
		user.setAge(23);
		user.setBirthday(new Date());
		user.setName("z3");
		user.setPwd("123");

		Transaction transaction = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			// 1.读取配置文件configuration
			Configuration configuration = new Configuration().configure();
			// 2.创建会话工厂SessionFactory
			sessionFactory = configuration.buildSessionFactory();
			// 3.取得会话Session
			session = sessionFactory.openSession();
			// 4开始事物Transaction
			transaction = session.beginTransaction();
			// 5执行持久化操作session.save(user)
			// 在sava调用前处于瞬时态，调用后处于持久态
			session.save(user);
			user.setAge(99);
			// 注意只有属性真的修改了才去数据库更新，由于这个时间user处于持久态，且真的修改了属性值
			// 在commit时间去做
			// session.update(user);
			// 6提交事物
			transaction.commit();// 成功提交
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();// 失败提交
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}// 这里user处于游离态
		}
	}
}
