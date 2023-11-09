package com.user.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int userId;
	private String name;
	private String phone;
	
	List<Contact> contacts = new ArrayList<>();

	public User() {
		
	}
	
	public User(int userId, String name, String phone) {

		this.userId = userId;
		this.name = name;
		this.phone = phone;
	}

	public User(int userId, String name, String phone, List<Contact> contacts) {
		
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.contacts = contacts;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phone=" + phone + "]";
	}
	
	

}
