package com.user.response;

import java.util.List;

import com.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithDepartment {
	
	private User user;
	private Department department;
	

}
