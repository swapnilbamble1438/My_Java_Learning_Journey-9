package com.employee_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	
	 

}
