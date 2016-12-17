package com.xbh.minioa.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xbh.minioa.cfg.Configuration;
import com.xbh.minioa.domain.PageBean;
import com.xbh.minioa.util.HqlHelper;

//@Transactional注解可以被继承，即对子类也有效
@SuppressWarnings("unchecked")
@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> clazz;// 这是一个问题

	@SuppressWarnings("rawtypes")
	public BaseDaoImpl() {
		// 通过反射得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];
		// System.out.println("clazz = " + clazz.getName());
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(Long id) {
		Object obj = getSession().get(clazz, id);
		getSession().delete(obj);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T getById(Long id) {
		if (id == null) {
			return null;
		}
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}
		return getSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)").setParameter("ids", ids).list();
	}

	@Override
	public List<T> findAll() {
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}

	/**
	 * 获取当前可用的Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	// 公共的查询分页信息的方法
	public PageBean getPageBean(int pageNum, String queryListHQL, Object[] parameters) {
		int pageSize = Configuration.getPageSize();
		// 查询本页的数据列表
		Query listQuery = getSession().createQuery(queryListHQL);
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				listQuery.setParameter(i, parameters[i]);
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		@SuppressWarnings("rawtypes")
		List list = listQuery.list();// 执行查询

		// 查询总记录数
		Query countQuery = getSession().createQuery("SELECT COUNT(*) " + queryListHQL);
		if (parameters != null && parameters.length > 0) { // 设置参数
			for (int i = 0; i < parameters.length; i++) {
				countQuery.setParameter(i, parameters[i]);
			}
		}
		Long count = (Long) countQuery.uniqueResult();// 执行查询
		return new PageBean(pageNum, pageSize, list, count.intValue());
	}

	@Override
	// 最终版
	public PageBean getPageBean(int pageNum, HqlHelper hqlHelper) {
		int pageSize = Configuration.getPageSize();
		List<Object> parameters = hqlHelper.getParameters();
		// 查询本页的数据列表
		Query listQuery = getSession().createQuery(hqlHelper.getQueryListHql());
		if (parameters != null && parameters.size() > 0) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		@SuppressWarnings("rawtypes")
		List list = listQuery.list(); // 执行查询
		// 查询总记录数
		Query countQuery = getSession().createQuery(hqlHelper.getQueryCountHql());
		if (parameters != null && parameters.size() > 0) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // 执行查询

		return new PageBean(pageNum, pageSize, list, count.intValue());
	}
}
