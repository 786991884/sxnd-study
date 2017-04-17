package com.xubh.mybatis.dao;


import java.util.List;

import com.xubh.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	public Employee getEmpById(Integer id);
	
	public List<Employee> getEmps();
	

}
