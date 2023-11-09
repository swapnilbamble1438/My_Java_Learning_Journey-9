package com.employee_service.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee_service.response.AddressResponse;

// http://localhost:8082/address/emp/{empid}
//put name same as instance name
@FeignClient(name="ADDRESS-SERVICE",path = "/address") // openfeign do loadbalancing automatically without adding any loadbalancing bean or annotation
public interface AddressClient {  // proxy

//	@GetMapping("/emp/{id}")
//	AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);

	
	@GetMapping("/emp/{empid}") // copy from address controller
	 ResponseEntity<AddressResponse> getAddressByEmpId(@PathVariable("empid") int empid);
	
	@GetMapping("/all")
	 ResponseEntity<List<AddressResponse>> getAllAddresses();





}
