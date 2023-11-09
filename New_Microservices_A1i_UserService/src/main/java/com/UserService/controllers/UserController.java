package com.UserService.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserService.entities.User;
import com.UserService.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userSerImpl;
	
	
	// create
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User createdUser = userSerImpl.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	// get single user
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable int userId)
	{
		User user = userSerImpl.getUser(userId);

		return ResponseEntity.ok(user);
		
	}
	
	// get all users
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> allUsers = userSerImpl.getAllUser();
		
		return ResponseEntity.ok(allUsers);
	}
	

}
