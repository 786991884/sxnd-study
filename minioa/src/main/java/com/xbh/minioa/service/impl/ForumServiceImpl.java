package com.xbh.minioa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xbh.minioa.base.BaseDaoImpl;
import com.xbh.minioa.domain.Forum;
import com.xbh.minioa.service.ForumService;

@Service
@SuppressWarnings("unchecked")
public class ForumServiceImpl extends BaseDaoImpl<Forum> implements ForumService {
	@Override
	public List<Forum> findAll() {
		return getSession().createQuery("FROM Forum f ORDER BY f.position ASC").list();
	}

	@Override
	public void save(Forum forum) {
		// 保存到DB，会生成ID的值
		getSession().save(forum);
		// 指定position的值为最大// SELECT MAX(f.position) FROM Forum f
		forum.setPosition(forum.getId().intValue());// 因为是持久化状态，所以不需要调用update()方法。
	}

	@Override
	public void moveUp(Long id) {
		// 获取要交换的两个Forum
		Forum forum = getById(id);// 当前操作的Forum
		// 上面的Forum
		Forum other = (Forum) getSession().createQuery("FROM Forum f WHERE f.position<? ORDER BY f.position DESC").setParameter(0, forum.getPosition()).setFirstResult(0).setMaxResults(1).uniqueResult();
		// 最上面的不能上移
		if (other == null) {
			return;
		}
		// 交换position的值
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		// 更新到数据库中
		// 因为是持久化状态，所以不需要调用update()方法。
	}

	@Override
	public void moveDown(Long id) {
		// 获取要交换的两个Forum
		Forum forum = getById(id);// 当前操作的Forum
		// 下面的Forum
		Forum other = (Forum) getSession().createQuery("FROM Forum f WHERE f.position>? ORDER BY f.position ASC").setParameter(0, forum.getPosition()).setFirstResult(0).setMaxResults(1).uniqueResult();
		// 最下面的不能下移
		if (other == null) {
			return;
		}
		// 交换position的值
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		// 更新到数据库中
		// 因为是持久化状态，所以不需要调用update()方法。
	}

}
