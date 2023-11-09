package com.employee_service.feignclient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

// it is a custom load balancer
// by default load balance will happen in round robin fashion
// but we are here providing random way of laod balancing


// you can remove this class it is optional

@LoadBalancerClient(name="ADDRESS-SERVICE",configuration = MyCustomLoadBalancerConfiguration.class)
public class AddressServiceLoadBalancer {
	
	@LoadBalanced
	@Bean
	public Feign.Builder feinBuilder()
	{
		return Feign.builder();
	}

}
