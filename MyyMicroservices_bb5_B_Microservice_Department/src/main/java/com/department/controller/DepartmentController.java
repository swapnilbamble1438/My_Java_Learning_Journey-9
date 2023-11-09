package com.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.entity.Department;
import com.department.service.DepartmentServ;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentServ depServ;
	
	
	
	@GetMapping("/{id}")
	public Department DepartmentById(@PathVariable("id") Long departmentId)
	{
		log.info("Inside findDepartmentById method of DepartmentController");
		 return this.depServ.getDepartmentById(departmentId);
	}

	
	@GetMapping("/all")
	public List<Department> AllDepartments()
	{
		log.info("Inside GetAllDepartments method of DepartmentController");
		return this.depServ.getAllDepartments();
	}

}
