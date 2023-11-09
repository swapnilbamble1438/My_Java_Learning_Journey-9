package com.user.model;

public class Contact {
	
	private int cId;
	private String email;
	private String contactName;
	
	
	private int userId;


	public Contact() {
	
	}


	public Contact(int cId, String email, String contactName) {
	
		this.cId = cId;
		this.email = email;
		this.contactName = contactName;
		
	}


	public Contact(int cId, String email, String contactName, int userId) {
	
		this.cId = cId;
		this.email = email;
		this.contactName = contactName;
		this.userId = userId;
	}


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContactName() {
		return contactName;
	}


	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", email=" + email + ", contactName=" + contactName + ", userId=" + userId + "]";
	}
	
	
	
	

}
