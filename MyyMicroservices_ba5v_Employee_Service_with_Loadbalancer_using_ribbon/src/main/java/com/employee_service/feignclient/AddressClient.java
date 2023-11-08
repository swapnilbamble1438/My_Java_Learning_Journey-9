package com.employee_service.feignclient;

import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee_service.response.AddressResponse;

// http://localhost:8082/address/emp/{empid}
@FeignClient(name = "address-service",path = "/address")
@RibbonClient(name="address-service")
public interface AddressClient {  // proxy

//	@GetMapping("/emp/{id}")
//	AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);

	
	@GetMapping("/emp/{empid}")
	 ResponseEntity<AddressResponse> getAddressByEmpId(@PathVariable("empid") int empid);





}
