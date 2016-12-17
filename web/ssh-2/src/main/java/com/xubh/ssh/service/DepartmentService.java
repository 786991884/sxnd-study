package com.xubh.ssh.service;

import java.util.List;

import com.xubh.ssh.dao.DepartmentDao;
import com.xubh.ssh.entities.Department;
import com.xubh.ssh.entities.Department;

public class DepartmentService {
	
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public List<Department> getAll(){
		return departmentDao.getAll();
	}
	
}
