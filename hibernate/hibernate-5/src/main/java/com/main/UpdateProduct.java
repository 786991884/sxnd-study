package com.main;

import org.hibernate.Session;

import com.bean.Product;
import com.hibernate.HibernateUtil;

public class UpdateProduct {
	// 修改指定产品信息
	public static void main(String[] args) {
		Session session = null; // 声明Session对象
		try {
			// Hibernate的持久化操作
			session = HibernateUtil.getSession();// 获取Session
			Product product = (Product) session.load(Product.class,
					new Integer("1"));// 装载对象
			product.setName("Java Web编程词典");// 修改商品名称
			product.setRemark("无");// 修改备注信息
			session.update(product);
			session.flush();
		} catch (Exception e) {
			System.out.println("对象修改失败");
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();// 关闭Session
		}
	}
}
