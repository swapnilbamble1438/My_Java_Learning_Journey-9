package com.userservice.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	// create
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User createdUser = userServ.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	
	int retryCount = 1;
	
	// get single user
	@GetMapping("/{userId}")
// @CircuitBreaker(name="RatingWithHotel",fallbackMethod = "RatingWithHotelFallback")// when using circuitbreaker dont use retry and ratelimiter
//	@Retry(name="RatingHotelService",fallbackMethod = "RatingWithHotelFallback") //when using retry  dont use circuit breaker
	@RateLimiter(name="userRateLimiter",fallbackMethod = "RatingWithHotelFallback") // when using ratelimiter dont use above retry and circuit
	public ResponseEntity<User> getSingleUser(@PathVariable int userId)
	{
		logger.info(" Retry count: {}", retryCount);
		System.out.println("================================================================================================================ \n"
				+" Retry count: "+ retryCount  +" \n"
				+ " ================================================================================================================"); // use when using retry
		retryCount++;
		
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

	
	
	
	
	// creating fallback method for circuit breaker
	public ResponseEntity<User> RatingWithHotelFallback(int userId,Exception ex)
	{
		
		User user = User.builder()
		.email("dummy@gmail.com").name("Dummy")
		.about("This is dummy user created because some services are down.").uid(0).build();
		logger.info("Fallback is executed because service is down: ",ex.getMessage());
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
