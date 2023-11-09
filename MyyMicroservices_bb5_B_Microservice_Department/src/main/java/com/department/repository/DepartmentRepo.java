package com.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.department.entity.Department;


public interface DepartmentRepo extends JpaRepository<Department,Long>{

	
	
	
}
