package com.xbh.minioa.service;

import java.util.List;

import com.xbh.minioa.base.BaseDao;
import com.xbh.minioa.domain.Privilege;

public interface PrivilegeService extends BaseDao<Privilege> {

	/**
	 * 查询所有顶级权限的集合
	 * 
	 * @return
	 */
	List<Privilege> findTopList();

	/**
	 * 查询所有权限URL的集合（不能有null，不能重复）
	 * 
	 * @return
	 */
	List<String> getAllPrivilegeUrls();

}
