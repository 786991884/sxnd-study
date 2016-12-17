package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bean.Product;
import com.hibernate.HibernateUtil;

public class SecondCache {
	// 使用二级缓存查询数据
	public static void main(String[] args) {
		Session session = null; // 声明第一个Session对象
		Session session2 = null; // 声明第二个Session对象
		try {
			session = HibernateUtil.getSession();// 获取第一个session
			session2 = HibernateUtil.getSession();// 获取第二个Session
			Product product = (Product) session.get(Product.class, new Integer(
					"1"));
			System.out.println("第一个session装载对象");
			Product product2 = (Product) session2.get(Product.class,
					new Integer("1"));// 装载对象
			System.out.println("第二个Session装载对象");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
