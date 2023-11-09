package com.userservice.controllers;


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

import com.userservice.entities.Rating;
import com.userservice.entities.User;
import com.userservice.impl.UserServiceImpl;
import com.userservice.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	
	// create
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User createdUser = userServ.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	// get single user
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable int userId)
	{
		User user = userServ.getUser(userId);
			
		
		return ResponseEntity.ok(user);
		
	}
	
	// get all users
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> allUsers = userServ.getAllUser();
		
		return ResponseEntity.ok(allUsers);
	}
	
	
	//create rating just for testing
	@PostMapping("/rating/create")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
		return ResponseEntity.ok(userServ.createRating(rating));
	}

}
