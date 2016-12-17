package com.xbh.minioa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xbh.minioa.base.BaseDaoImpl;
import com.xbh.minioa.domain.Department;
import com.xbh.minioa.service.DepartmentService;

@Service
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends BaseDaoImpl<Department> implements DepartmentService {

	@Override
	public List<Department> findTopList() {
		return getSession().createQuery("FROM Department d WHERE d.parent IS NULL").list();
	}

	@Override
	public List<Department> findChildren(Long parentId) {
		return getSession().createQuery("FROM Department d WHERE d.parent.id=?").setParameter(0, parentId).list();
	}

}
