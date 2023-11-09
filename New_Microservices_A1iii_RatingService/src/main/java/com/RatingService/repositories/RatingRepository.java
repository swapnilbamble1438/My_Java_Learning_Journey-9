package com.RatingService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RatingService.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer>{

	
	// custom methods
	
	List<Rating> findByUid(int uid);
	
	List<Rating> findByHid(int hid);
	
	
}
