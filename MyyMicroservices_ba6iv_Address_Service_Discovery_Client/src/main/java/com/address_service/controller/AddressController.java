package com.address_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.address_service.response.AddressResponse;
import com.address_service.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addServ;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllAddresses()
	{
		List<AddressResponse> addRess = addServ.getAllAddresses();
		return ResponseEntity.ok(addRess);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressResponse> getAddressById(@PathVariable("id") int id)
	{
		AddressResponse addRes = addServ.getAddressById(id);
		return ResponseEntity.ok(addRes);
	}
	
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<AddressResponse> getAddressByEmpId(@PathVariable("empid") int empid)
	{
		AddressResponse addRes = addServ.getAddressByEmpId(empid);
		return ResponseEntity.ok(addRes);
	}

}
