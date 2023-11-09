package com.userservice.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.entities.Hotel;
import com.userservice.entities.Rating;
import com.userservice.entities.User;
import com.userservice.exceptions.ResourceNotFoundException;
import com.userservice.feignclients.HotelClient;
import com.userservice.feignclients.RatingClient;
import com.userservice.repositories.UserRepository;
import com.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
//	@Value("${ratingservice.base.url}")
//	private String ratingServiceBaseURL;
//	
//	@Value("${hotelservice.base.url}")
//	private String hotelServiceBaseURL;
	
	@Autowired
	private RatingClient ratingClient;
	
	@Autowired
	private HotelClient hotelClient;

	@Override
	public User saveUser(User user) {
		
//		String randomUserId = UUID.randomUUID().toString();  // generating random Id
//		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}

	@Override
	public User getUser(int userId) {
		
		User user = userRepo.findById(userId).orElseThrow(() 
				-> new ResourceNotFoundException(
						"User with given id: "+userId+" is not found on server !!"
						));
		

		// fetch rating from rating service
		
	//	List<Rating> rating = restTemplate.getForObject(ratingServiceBaseURL +"/user/{userId}", ArrayList.class,user.getUid());
	//	Rating[] ratingsArr = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getUid(),Rating[].class);
	//	logger.info("{}",ratingsArr);
		
	//	List<Rating> ratings = Arrays.stream(ratingsArr).toList();
		List<Rating> ratings =	ratingClient.getRatingByUid(user.getUid()).getBody();


		ratings.forEach(rating->{
		//	ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHid(),Hotel.class);
			ResponseEntity<Hotel> hotelEntity = hotelClient.getHotelById(rating.getHid());

			Hotel hotel = hotelEntity.getBody();
			rating.setHotel(hotel);
	});
	
		
		user.setRatings(ratings);
	
		return user;
		
		
	}

	
	// creating rating just for testing
	@Override
	public Rating createRating(Rating rating) {
		
		Rating createdRating = ratingClient.createRating(rating).getBody();
		
		return createdRating;
	}

}

