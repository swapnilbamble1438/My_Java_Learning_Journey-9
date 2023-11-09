package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.model.User;




@Service
public class UserServiceImpl implements UserService{

	
	//fake user list
	
	List<User> list = List.of(
			new User(1,"Swapnil","1234567891"),
			new User(2,"Yash","1234567891"),
			new User(3,"Pratik","1234567891")
			);
	
	
	@Override
	public User getUser(int id) {
		
		return list.stream().filter(user -> user.getUserId() ==(id)).findAny().orElse(null);
	}

}
