package com.xbh.minioa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xbh.minioa.base.BaseDaoImpl;
import com.xbh.minioa.domain.Privilege;
import com.xbh.minioa.service.PrivilegeService;

@SuppressWarnings("unchecked")
@Service
public class PrivilegeServiceImpl extends BaseDaoImpl<Privilege> implements PrivilegeService {

	@Override
	public List<Privilege> findTopList() {
		return getSession().createQuery("FROM Privilege p WHERE p.parent IS NULL").list();
	}

	@Override
	public List<String> getAllPrivilegeUrls() {
		return getSession().createQuery("SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL").list();
	}

}
