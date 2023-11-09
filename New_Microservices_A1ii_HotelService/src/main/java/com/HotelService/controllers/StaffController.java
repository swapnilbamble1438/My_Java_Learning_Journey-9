package com.HotelService.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@GetMapping("/all")
	public ResponseEntity<List<String>> getStaffs()
	{
		List<String> list = Arrays.asList("Raj","Nitin","Rakesh","Rahul");
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

}
