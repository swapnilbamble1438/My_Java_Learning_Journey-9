package com.employee_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@EnableFeignClients
@SpringBootApplication
public class MySpringBootBa7iEmployeeServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootBa7iEmployeeServiceApplication.class, args);
	}
	

}
