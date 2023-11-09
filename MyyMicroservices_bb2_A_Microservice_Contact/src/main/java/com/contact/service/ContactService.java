package com.contact.service;

import java.util.List;


import com.contact.model.Contact;


public interface ContactService {
	
	public List<Contact> getContactOfUser(int userId);

}
