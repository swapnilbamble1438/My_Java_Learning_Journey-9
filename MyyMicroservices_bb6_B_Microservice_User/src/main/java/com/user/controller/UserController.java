package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;
import com.user.response.Department;
import com.user.response.UserWithDepartment;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserService userServ;
	
	
	@GetMapping("/{id}/withdept")
	public UserWithDepartment getUserWithDepartment(@PathVariable("id") Long id)
	{
		UserWithDepartment userWithDept = new UserWithDepartment();
		
		User user = userServ.getUserById(id);
	
	//	Department department = restTemplate.getForObject("http://localhost:8082/department/" + user.getDepartmentId(),Department.class);
		Department department = restTemplate.getForObject("http://department-service/department/" + user.getDepartmentId(),Department.class);
		
		userWithDept.setUser(user);
		userWithDept.setDepartment(department);
		
		return userWithDept;
		
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Long userId)
	{
		 return this.userServ.getUserById(userId);
	}

	
	@GetMapping("/all")
	public List<User> GetAllUsers()
	{
		return this.userServ.getAllUsers();
	}

	

}
