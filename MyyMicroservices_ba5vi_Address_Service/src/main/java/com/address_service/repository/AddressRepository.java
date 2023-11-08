package com.address_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.address_service.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	

	
}
