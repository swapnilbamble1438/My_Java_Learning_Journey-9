package com.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.model.Contact;
import com.user.model.User;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private com.user.service.UserService userService;
	
	/*
	@RequestMapping("/{userId}")
	public User getUser(@PathVariable("userId") int userId)
	{
		
		User user = userService.getUser(userId);
		
	
		return user;
		
		
	}
	*/
	
	
	@RequestMapping("/{userId}")
	public User getUser(@PathVariable("userId") int userId)
	{
		
		User user = userService.getUser(userId);
		
	//    List contacts = restTemplate.getForObject("http://localhost:8082/contact/user/"+user.getUserId(), List.class);
	    List contacts = restTemplate.getForObject("http://contact-service/contact/user/"+user.getUserId(), List.class);
		
		user.setContacts(contacts);
	
		return user;
		
		
	}
	
}
