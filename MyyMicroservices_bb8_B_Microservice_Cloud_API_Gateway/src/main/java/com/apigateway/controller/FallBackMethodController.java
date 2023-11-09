package com.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
	
	
	
	@GetMapping("/userservicefallback")
	public String userServiceFallBackMethod()
	{
		return "User Service is taking longer than Expected. +"
				+ " Please try again later";
	}

	
	@GetMapping("/departmentservicefallback")
	public String departmentServiceFallBackMethod()
	{
		return "Department Service is taking longer than Expected. +"
				+ " Please try again later";
	}

}
