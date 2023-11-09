package com.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient  
@EnableHystrix
public class MySpringBootBa2ivMicroserviceCloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootBa2ivMicroserviceCloudApiGatewayApplication.class, args);
	}

}
