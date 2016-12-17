package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bean.Product;
import com.hibernate.HibernateUtil;

public class DeleteProduct {
	// 删除指定产品信息
	public static void main(String[] args) {
		Session session = null; // 声明Session对象
		try {
			// Hibernate的持久化操作
			session = HibernateUtil.getSession();// 获取Session
			Product product = (Product) session.get(Product.class, new Integer(
					"1"));// 装载对象
			session.delete(product);// 删除持久化信息
			session.flush();// 强制刷新提交
		} catch (HibernateException e) {
			System.out.println("对象删除失败");
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
