package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bean.Product;
import com.hibernate.HibernateUtil;

public class GetProduct_getload {
	// 利用get()方法装载对象
	public static void main(String[] args) {
		Session session = null; // 声明Session对象
		try {
			// hibernate的持久化操作
			session = HibernateUtil.getSession();// 获取Session
			Product product = (Product) session.get(Product.class, new Integer(
					"1"));// 装载对象
			System.out.println("第一次装载对象");
			Product product2 = (Product) session.get(Product.class,
					new Integer("1"));// 装载对象
			System.out.println("第二次装载对象");
		} catch (NumberFormatException e) {
			System.out.println("对象装载失败");
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();// 关闭session
		}
	}
}
