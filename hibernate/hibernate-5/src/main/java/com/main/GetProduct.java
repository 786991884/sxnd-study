package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bean.Product;
import com.hibernate.HibernateUtil;

public class GetProduct {
	// 利用get()方法装载对象
	public static void main(String[] args) {
		Session session = null; // 声明Session对象
		// Hibernate的持久化操作
		try {
			session = HibernateUtil.getSession();// 获取Session
			Product product = (Product) session.get(Product.class, new Integer(
					"1"));// 装载对象
			System.out.println("产品ID:" + product.getId());
			System.out.println("产品名称：" + product.getName());
			System.out.println("产品价格：" + product.getPrice() + "元");
			System.out.println("生产厂商：" + product.getFactory());
			System.out.println("产品备注：" + product.getRemark());
		} catch (HibernateException e) {
			System.out.println("对象装载失败");
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();// 关闭Session
		}
	}
}
