package com.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class NewMicroservicesA2iUserServiceFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewMicroservicesA2iUserServiceFeignClientApplication.class, args);
	}

}
