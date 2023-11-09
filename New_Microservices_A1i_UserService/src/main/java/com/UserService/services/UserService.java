package com.UserService.services;

import java.util.List;

import com.UserService.entities.User;

public interface UserService {
	
	// create
	User saveUser(User user);
	
	// get all user
	List<User> getAllUser();
	
	//get single user
	User getUser(int userId);
	
	// delete
	
	// update
	

}