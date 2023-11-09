package com.userservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.userservice.entities.Rating;


@FeignClient(name="RATING-SERVICE")
public interface RatingClient {
	
	@GetMapping("/rating/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUid(@PathVariable("userId") int userId);
	
	
	// this rating are just for testing
	
	@PostMapping("/rating/create")
	ResponseEntity<Rating> createRating(Rating rating);
	
	@PutMapping("/rating/update/{ratingId}")
	ResponseEntity<Rating> updateRating(@PathVariable("ratingId")int ratingId,Rating rating);
	
	
	@DeleteMapping("/rating/delete/{ratingId}")
	ResponseEntity<Rating> deleteRating(@PathVariable("ratingId") int ratingId);
	
	
}
