package com.RatingService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RatingService.entities.Rating;
import com.RatingService.repositories.RatingRepository;
import com.RatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratRepo;

	@Override
	public Rating create(Rating rating) {

		return ratRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		
		return ratRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUid(int userId) {

		return ratRepo.findByUid(userId);
	}

	@Override
	public List<Rating> getRatingByHid(int hotelId) {
		
		return ratRepo.findByHid(hotelId);
	}

}
