package com.discovery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MySpringBootBa6iDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootBa6iDiscoveryServiceApplication.class, args);
	}

}
