package com.xubh.sssp.repository;

import java.util.List;

import javax.persistence.QueryHint;

import com.xubh.sssp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	@QueryHints({@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
	@Query("FROM Department d")
	List<Department> getAll();
	
}
