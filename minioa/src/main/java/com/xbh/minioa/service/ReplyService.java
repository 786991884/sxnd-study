package com.xbh.minioa.service;

import java.util.List;

import com.xbh.minioa.base.BaseDao;
import com.xbh.minioa.domain.PageBean;
import com.xbh.minioa.domain.Reply;
import com.xbh.minioa.domain.Topic;

public interface ReplyService extends BaseDao<Reply> {
	/**
	 * 查询指定主题的所有的回复列表，排序：最前面的是最早发表的回帖
	 * 
	 * @param topic
	 * @return
	 */
	@Deprecated
	List<Reply> findByTopic(Topic topic);

	/**
	 * 获取分页信息
	 * 
	 * @param pageNum
	 * @param topic
	 * @return
	 */
	@Deprecated
	PageBean getPageBean(int pageNum, Topic topic);
}
