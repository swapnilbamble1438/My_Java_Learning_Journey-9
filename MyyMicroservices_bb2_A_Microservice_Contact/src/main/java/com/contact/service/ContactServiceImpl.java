package com.contact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.model.Contact;

@Service
public class ContactServiceImpl implements ContactService{

	
	List<Contact> list = List.of(
				new Contact(1,"deepak@gmail.com","Deepak Sawant",1),
				new Contact(2,"raj@gmail.com","Raj Tidkaiya",2),
				new Contact(3,"nitin@gmail.com","Nitin Sharma",3),
				new Contact(4,"rakesh@gmail.com","Rakesh Jadhav",1),
				new Contact(5,"smit@gmail.com","Smit Sharma",2),
				new Contact(6,"girish@gmail.com","Girish Narvekar",3)
			);
	
	
	@Override
	public List<Contact> getContactOfUser(int userId) {
		
		return list.stream().filter(contact -> contact.getUserId() ==(userId)).collect(Collectors.toList());

	}

}
