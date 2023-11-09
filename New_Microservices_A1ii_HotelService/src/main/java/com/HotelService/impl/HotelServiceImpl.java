package com.HotelService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelService.entities.Hotel;
import com.HotelService.repositories.HotelRepository;
import com.HotelService.services.HotelService;
import com.HotelService.exceptions.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService{

	
	@Autowired
	private HotelRepository hotelRepo;
	
	
	@Override
	public Hotel create(Hotel hotel) {
		
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(int id) {

		return hotelRepo.findById(id).orElseThrow(()
				-> new ResourceNotFoundException(
						"Hotel with given id: "+id+" is not found on server !!"
						));
	
	}

}
