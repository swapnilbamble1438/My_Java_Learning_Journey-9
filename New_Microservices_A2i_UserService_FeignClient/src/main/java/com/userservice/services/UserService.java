package com.userservice.services;

import java.util.List;

import com.userservice.entities.Rating;
import com.userservice.entities.User;

public interface UserService {
	
	// create
	User saveUser(User user);
	
	// get all user
	List<User> getAllUser();
	
	//get single user
	User getUser(int userId);
	
	// delete
	
	// update
	
	
	// creating rating just for testing
	Rating createRating(Rating rating);
	
	
	

}