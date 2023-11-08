package com.employee_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@EnableFeignClients
@SpringBootApplication
public class MySpringBootBa5vEmployeeServiceWithLoadbalancerUsingRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootBa5vEmployeeServiceWithLoadbalancerUsingRibbonApplication.class, args);
	}
	
	
	

}
