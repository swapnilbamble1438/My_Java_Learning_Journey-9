package com.RatingService.services;

import java.util.List;

import com.RatingService.entities.Rating;

public interface RatingService{

	
	// create
	Rating create(Rating rating);
	
	
	
	// gel all ratings
	List<Rating> getAllRatings();
	
	
	
	// get all uid
	List<Rating> getRatingByUid(int userId);
	
	
	
	// get all by hid
	List<Rating> getRatingByHid(int hotelId);
	
}

