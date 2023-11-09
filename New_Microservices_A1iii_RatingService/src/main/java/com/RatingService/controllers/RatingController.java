package com.RatingService.controllers;

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

import com.RatingService.entities.Rating;
import com.RatingService.services.RatingService;


@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingService ratServ;
	
	// create rating
	@PostMapping("/create")
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratServ.create(rating));
	}
	
	
	// get all
	@GetMapping("/all")
	public ResponseEntity<List<Rating>> getAllRatings()
	{
		return ResponseEntity.ok(ratServ.getAllRatings());
	}
	
	// get ratings by UserId
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUid(@PathVariable("userId") int userId)
	{
		return ResponseEntity.ok(ratServ.getRatingByUid(userId));
	}
	
	// get ratings by HotelId
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHid(@PathVariable("hotelId") int hotelId)
	{
		return ResponseEntity.ok(ratServ.getRatingByHid(hotelId));
	}
	

}
