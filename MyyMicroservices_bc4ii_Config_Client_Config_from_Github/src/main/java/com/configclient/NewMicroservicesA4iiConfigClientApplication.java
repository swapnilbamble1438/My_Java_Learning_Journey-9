package com.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NewMicroservicesA4iiConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewMicroservicesA4iiConfigClientApplication.class, args);
	}

}
