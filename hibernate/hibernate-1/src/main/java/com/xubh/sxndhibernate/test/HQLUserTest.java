package com.xubh.sxndhibernate.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.xubh.sxndhibernate.entity.User;

public class HQLUserTest {
	@Test
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

			Query query = session.createQuery("from User");
			List<User> list = query.list();
			// query.iterate();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("age", 22));
			for (Object obj : list) {
				// 投影返回的List每个元素是一个object数组
				Object[] arrObj = (Object[]) obj;
			}

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
			}
		}
	}

	@Test
	public void updateUser() {
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
			User user = (User) session.get(User.class, 2);
			System.out.println(user.getAge());
			user.setAge(22);
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
			}
		}
	}

	@Test
	public void readUser() {
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
			// 4开启事物Transaction
			transaction = session.beginTransaction();
			// 5执行持久化操作session
			// get的工作过程，首先到一级缓存找，如果找不到就到二级缓存（存在），再找不到就到数据库查找
			User user = (User) session.get(User.class, 1);
			User user1 = (User) session.get(User.class, 1);
			User user2 = (User) session.load(User.class, 1);
			// 这里运行的结果为true，说明第二次没有到数据库，肯定在某个地方去找到这个指定id
			// id的对象，称为一级缓存，其实就是内在的一个区域，它关不掉
			System.out.println(user == user1);
			System.out.println(user2.getClass());
			// user2.getClass这个类型的Users的子类
			// load有一个懒加载特性，也称为延迟加载：访问非id,非getClass()抛出异常
			/**
			 * 1,get没有延迟加载特性而load有延迟加载特性 2,如果指定id不存在，get返回null没有异常
			 * 相同点都是按照如下顺序查找对象:一级缓存 二级缓存 到数据库
			 */
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
			}
		}
	}

	@Test
	public void deleteUser() {
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
			session.delete(session.load(User.class, 2));
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
			}
		}
	}
}
