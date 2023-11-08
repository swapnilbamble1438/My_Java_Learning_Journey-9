package com.employee_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee_service.model.Employee;
import com.employee_service.response.AddressResponse;
import com.employee_service.response.EmployeeResponse;
import com.employee_service.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empServ;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeResponse>> getAllEmployees()
	{
		
		List<EmployeeResponse> empRess = empServ.getAllEmployees();
		
		return ResponseEntity.status(HttpStatus.OK).body(empRess);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") int id)
	{
		EmployeeResponse empRes = empServ.getEmpById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(empRes);
	}
	
	
	@GetMapping("/allwithaddress")
	public ResponseEntity<List<EmployeeResponse>> getAllEmployeesWithAddress()
	{
		
		List<EmployeeResponse> empRess = empServ.getAllEmployeesWithAddress();
		
		return ResponseEntity.status(HttpStatus.OK).body(empRess);
	}
	
	
}
