package com.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {
	
	@Autowired 
	private RestTemplate restTemplate;

	@GetMapping("/employee")
	public String getEmployee() {
		
		//return the address data along with the employee data
		
		String address = null; 
		
		// get the address data by hitting url at which address service is running
		
		address = restTemplate.getForObject("http://localhost:8080/address", String.class);
		
		return "<b>Name</b>: Swapnil Bamble, <br>"
				+ " <b>Email</b>: swapnil@gmail.com, <br>" 
		        + address;
	}
}
