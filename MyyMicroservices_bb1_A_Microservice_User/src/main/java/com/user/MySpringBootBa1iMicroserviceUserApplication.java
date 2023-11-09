package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MySpringBootBa1iMicroserviceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootBa1iMicroserviceUserApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate resTemplate()
	{
		return new RestTemplate();
	}
}
