package com.eserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MySpringBootBa1iiMicroserviceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootBa1iiMicroserviceEurekaServerApplication.class, args);
	}

}
