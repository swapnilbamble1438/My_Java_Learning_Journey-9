package com.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MySpringBootBa1iMicroserviceContactApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootBa1iMicroserviceContactApplication.class, args);
	}

}
