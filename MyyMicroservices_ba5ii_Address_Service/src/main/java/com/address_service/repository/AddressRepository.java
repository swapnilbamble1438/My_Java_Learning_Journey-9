package com.address_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.address_service.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	

//	@Query(nativeQuery = true,value="select * from address where empid = :empid")
//	public Address getAddressByEmployeeId(@Param("empid")int empid);
//	
	
}
