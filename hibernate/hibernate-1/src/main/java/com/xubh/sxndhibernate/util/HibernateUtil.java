package com.xubh.sxndhibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	// 伪单例模式
	public HibernateUtil() {
	}

	private static SessionFactory sessionFactory;
	static {
		// 1.读取配置文件configuration
		Configuration configuration = new Configuration().configure();
		// 2.创建会话工厂SessionFactory
		sessionFactory = configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
