package com.department.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.entity.Department;
import com.department.repository.DepartmentRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServ {
	
	
	@Autowired
	private DepartmentRepo depRepo;
	
//===================================================================================================	

	private static List<Department> list = new ArrayList<>();
	
	static {
		 list.add(new Department(1L,"IT","Mumbai","IT-1"));
		 list.add(new Department(2L,"Physics","Thane","Physics-2"));
		 list.add(new Department(3L,"Chemistry","Pune","Chemistry-3"));
	}
	
//===================================================================================================	
	
	
	
	// get all Departments
	public List<Department> getAllDepartments()
	{
		return list;
	}
	
	
	// get Department By Id
	public Department getDepartmentById(Long departmentId) {
		
		log.info("Inside getDepartmentById method of DepartmentService");

		Department department = null;
		department = list.stream().filter(e -> e.getDepartmentId()==departmentId).findFirst().get();
		return department;
	}
	
	
	

	
	
		

}
