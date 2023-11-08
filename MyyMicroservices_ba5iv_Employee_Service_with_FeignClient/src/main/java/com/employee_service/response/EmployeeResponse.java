package com.employee_service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeResponse {
	
	private int id;
	private String name;
	private String email;
	private String bloodgroup;
	
	private AddressResponse addressResponse;
	
	

	

}