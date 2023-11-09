package com.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
