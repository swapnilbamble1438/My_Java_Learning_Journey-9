package com.user.response;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Data
public class Department {
	
	
	private Long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	

	
	
	
	

}
