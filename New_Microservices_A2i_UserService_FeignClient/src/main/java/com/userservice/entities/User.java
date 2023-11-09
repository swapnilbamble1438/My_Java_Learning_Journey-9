package com.userservice.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User")
public class User {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	//private String userId;
	
	@Column(name = "NAME",length=30)
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ABOUT")
	private String about;
	
	@Transient   // means it will ignore this field. and this field will not store in database
	private List<Rating> ratings = new ArrayList<>(); // we have to take this field content from the another microservice
	

}
