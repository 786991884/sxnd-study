package com.xbh.minioa.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.xbh.minioa.base.BaseDaoImpl;
import com.xbh.minioa.domain.User;
import com.xbh.minioa.service.UserService;

@Service
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {

	public User getByLoginNameAndPassword(String loginName, String password) {
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?").setParameter(0, loginName)//
				.setParameter(1, DigestUtils.md5Hex(password))// 要使用MD5的摘要
				.uniqueResult();
	}

}
