package com.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	static SessionFactory sessionFactory;
	private Session session = null;
	private Transaction tx = null;
	// 初始化Hibernate,创建SessionFactory实例,只在该类被加载到内存时执行一次
	static {
		try {
			Configuration config = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	// 开启session
	public void openSession() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();// 开启事务
	}

	// 获取留言信息列表
	public List<TbMessage> listMessage() {
		openSession();// 开启session
		String hql = "from TbMessage m order by m.sendTime desc";// 降序查询全部留言信息
		List<TbMessage> list = null;
		try {
			Query query = session.createQuery(hql);
			list = (List<TbMessage>) query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	// 获取指定留言信息
	public TbMessage getMessage(int id) {
		openSession();// 开启session
		TbMessage tbMessage = (TbMessage) session.get(TbMessage.class, id);// 通过get方法查询指定ID的留言信息
		session.close();
		return tbMessage;
	}

	// 修改留言信息
	public String updateMessage(TbMessage message) {
		try {
			openSession();// 开启session
			// 在应用update()方法时，应该先调用get()方法加载数据，然后再调用update()方法更新数据
			TbMessage m = (TbMessage) session.get(TbMessage.class,
					message.getId());
			m.setWriter(message.getWriter());
			m.setContent(message.getContent());
			session.update(m);// 应用update()方法修改留言信息到数据库
			tx.commit(); // 提交事务
			return "留言信息修改成功！";
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();// 事务回滚
			return "修改留言信息失败！";
		} finally {
			closeSession();// 关闭session
		}
	}

	// 关闭session
	public void closeSession() {
		session.close();
	}
}
