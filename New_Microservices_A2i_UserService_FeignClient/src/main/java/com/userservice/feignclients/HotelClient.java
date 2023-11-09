package com.userservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.entities.Hotel;


@FeignClient(name="HOTEL-SERVICE")
public interface HotelClient {


	@GetMapping("/hotel/{hotelId}")
 ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") int hotelId);
	
	
}
