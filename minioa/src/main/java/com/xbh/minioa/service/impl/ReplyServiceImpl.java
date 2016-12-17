package com.xbh.minioa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xbh.minioa.base.BaseDaoImpl;
import com.xbh.minioa.cfg.Configuration;
import com.xbh.minioa.domain.Forum;
import com.xbh.minioa.domain.PageBean;
import com.xbh.minioa.domain.Reply;
import com.xbh.minioa.domain.Topic;
import com.xbh.minioa.service.ReplyService;

@Service
@SuppressWarnings("unchecked")
public class ReplyServiceImpl extends BaseDaoImpl<Reply> implements ReplyService {

	@Override
	public List<Reply> findByTopic(Topic topic) {
		// 排序：最前面的是最早发表的回帖
		return getSession().createQuery("FROM Reply r WHERE t.topic=? ORDER BY r.postTime ASC").setParameter(0, topic).list();
	}

	@Override
	public void save(Reply reply) {
		// 保存到DB
		getSession().save(reply);

		// 维护相关的信息
		Topic topic = reply.getTopic();
		Forum forum = topic.getForum();
		forum.setArticleCount(forum.getArticleCount() + 1);// 版块的文章数（主题+回复）
		topic.setReplyCount(topic.getReplyCount() + 1); // 主题的回复数
		topic.setLastReply(reply);// 主题的最后发表的回复
		topic.setLastUpdateTime(reply.getPostTime());// 主题的最后更新的时间（主题的发表时间或是最后回复的时间）
		getSession().update(topic);
		getSession().update(forum);

	}

	@Override
	@SuppressWarnings("rawtypes")
	public PageBean getPageBean(int pageNum, Topic topic) {
		int pageSize = Configuration.getPageSize();
		// 查询本页的数据列表
		List list = getSession().createQuery(//
				"FROM Reply r WHERE r.topic=? ORDER BY r.postTime ASC")//
				.setParameter(0, topic)//
				.setFirstResult((pageNum - 1) * pageSize)//
				.setMaxResults(pageSize)//
				.list();
		// 查询总记录数
		Long count = (Long) getSession().createQuery(//
				"SELECT COUNT(*) FROM Reply r WHERE r.topic=?")//
				.setParameter(0, topic)//
				.uniqueResult();

		return new PageBean(pageNum, pageSize, list, count.intValue());
	}

}
