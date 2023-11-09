package com.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class NewMicroservicesA1iUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewMicroservicesA1iUserServiceApplication.class, args);
	}
	
	

}
