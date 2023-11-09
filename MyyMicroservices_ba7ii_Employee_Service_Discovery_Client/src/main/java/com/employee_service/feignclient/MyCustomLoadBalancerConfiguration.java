package com.employee_service.feignclient;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;


//it is a custom load balancer
//by default load balance will happen in round robin fashion
//but we are here providing random way of laod balancing


//you can remove this class it is optional

public class MyCustomLoadBalancerConfiguration {

	@Bean
	ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
	LoadBalancerClientFactory loadBalancerClientFactory){
		
		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
		
		return new RandomLoadBalancer(loadBalancerClientFactory
				.getLazyProvider(name, ServiceInstanceListSupplier.class),
				name);
	
	}
			
			
}
