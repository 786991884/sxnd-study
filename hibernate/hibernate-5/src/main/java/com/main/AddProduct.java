package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bean.Product;
import com.hibernate.HibernateUtil;

public class AddProduct {
	/**
	 * 添加商品
	 */
	public static void main(String[] args) {
		Session session = null; // 声明Session对象
		Product product = new Product();// 实例化持久化类
		// 为持久化类属性赋值
		product.setName("Java Web编程宝典");// 设置产品名称
		product.setPrice(79.00);// 设置产品价格
		product.setFactory("明日科技");// 设置生产商
		product.setRemark("无");// 无
		// Hibernate的持久化操作
		try {
			session = HibernateUtil.getSession();// 获取Session
			session.beginTransaction();// 开启事务
			session.save(product);// 执行数据库添加操作
			session.getTransaction().commit();// 事务提交
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();// 事务回滚
			System.out.println("数据添加失败");
		} finally {
			HibernateUtil.closeSession();// 关闭Session对象
		}
	}
}
