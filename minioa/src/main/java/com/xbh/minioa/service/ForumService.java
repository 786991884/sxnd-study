package com.xbh.minioa.service;

import com.xbh.minioa.base.BaseDao;
import com.xbh.minioa.domain.Forum;

public interface ForumService extends BaseDao<Forum> {
	/**
	 * 上移，最上面的不能上移
	 * 
	 * @param id
	 */
	void moveUp(Long id);

	/**
	 * 下移，最下面的不能下移
	 * 
	 * @param id
	 */
	void moveDown(Long id);
}
