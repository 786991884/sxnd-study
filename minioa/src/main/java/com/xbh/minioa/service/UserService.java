package com.xbh.minioa.service;

import com.xbh.minioa.base.BaseDao;
import com.xbh.minioa.domain.User;

public interface UserService extends BaseDao<User> {

	/**
	 * 查询用户
	 * 
	 * @param loginName
	 * @param password
	 *            明文密码
	 * @return
	 */
	User getByLoginNameAndPassword(String loginName, String password);

}
