package com.xubh.ssh.dao;

import java.util.List;

import com.xubh.ssh.entities.Department;
import com.xubh.ssh.entities.Department;

public class DepartmentDao extends BaseDao{

	public List<Department> getAll(){
		String hql = "FROM Department";
		return getSession().createQuery(hql).list();
	}
	
}
