package com.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public class UserService {

	
	private static List<User> list = new ArrayList<>();

	
	
	static {
		 list.add(new User(101L,"Swapnil","Bamble","swapnil@gmail.com",1L));
		 list.add(new User(102L,"Yash","More","yash@gmail.com",2L));
		 list.add(new User(103L,"Pratik","Shinde","pratik@gmail.com",3L));
		 list.add(new User(104L,"Deepak","Sawant","deepak@gmail.com",2L));
		 list.add(new User(105L,"Zurez","Malik","zurez@gmail.com",3L));
		
	}
	
	
		// get all users
		public List<User> getAllUsers()
		{
			return list;
		}
		
		
		// get User By Id
		public User getUserById(Long userId) {
			

			User user = null;
			user = list.stream().filter(e -> e.getUserId()==userId).findFirst().get();
			return user;
		}
		
		// get User By Id
		public User getUserWithDepartmentId(Long departmentId) {
			

			User user = null;
		 user = list.stream().filter(e -> e.getDepartmentId()==departmentId).findFirst().get();
			// List<UserDto> userDtos =	users.stream().map(user->UserToDto(user)).collect(Collectors.toList());
	
		 
		 return user;
		}
		
		
		
	
		
}
