package com.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NewMicroservicesA1ivServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewMicroservicesA1ivServiceRegistryApplication.class, args);
	}

}
