package com.employee_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class MySpringBootBa6iiEmployeeServiceDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootBa6iiEmployeeServiceDiscoveryClientApplication.class, args);
	}

}
