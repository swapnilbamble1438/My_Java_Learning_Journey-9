package com.UserService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserService.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	// if you want to implement any custom method or query
	// write
}
