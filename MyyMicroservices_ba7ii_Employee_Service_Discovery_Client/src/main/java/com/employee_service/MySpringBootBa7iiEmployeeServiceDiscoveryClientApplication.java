package com.employee_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient // it is optional and it is better from using @EnableEurekaClient
public class MySpringBootBa7iiEmployeeServiceDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootBa7iiEmployeeServiceDiscoveryClientApplication.class, args);
	}

}
