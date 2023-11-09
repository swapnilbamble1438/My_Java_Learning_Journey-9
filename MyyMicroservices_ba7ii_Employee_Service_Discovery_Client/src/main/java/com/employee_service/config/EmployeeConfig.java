package com.employee_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee_service.feignclient.AddressClient;
import com.employee_service.response.AddressResponse;

@Configuration
public class EmployeeConfig {
	
	@Value("${address-service.base.url}")
		private String addressBaseURL;
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	
	@Bean
	public WebClient webClient()
	{
		return WebClient
				.builder()
				.baseUrl(addressBaseURL)
				.build();
	}

	
	@LoadBalanced // put this when using third way // pick url from eureka server from round robbin fashion
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	
	 

}
