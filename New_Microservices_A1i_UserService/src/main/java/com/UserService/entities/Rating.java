package com.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	
	private int rid;
	private int uid;
	private int hid;
	private int rating;
	private String feedback;
	
	private Hotel hotel;
	
	

}
