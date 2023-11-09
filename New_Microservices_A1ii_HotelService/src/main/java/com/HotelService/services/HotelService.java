package com.HotelService.services;

import java.util.List;

import com.HotelService.entities.Hotel;

public interface HotelService {
	
	
	//create
	Hotel create(Hotel hotel);
	
	
	//getall
	List<Hotel> getAll();
	
	
	
	//get single
	Hotel get(int id);
	
}
