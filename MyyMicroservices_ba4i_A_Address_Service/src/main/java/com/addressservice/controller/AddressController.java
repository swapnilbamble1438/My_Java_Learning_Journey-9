package com.addressservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
	
	@GetMapping("/address")
	public String getAddress()
	{
		return " <b>Address</b>: Saidham Bldg,Thakurpada,Mumbra,Thane,Maharashtra";
	}

}
