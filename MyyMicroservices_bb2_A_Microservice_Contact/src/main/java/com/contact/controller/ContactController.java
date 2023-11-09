package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.model.Contact;
import com.contact.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	
	@RequestMapping("/user/{userId}")
	public List<Contact> getContacts(@PathVariable("userId") int userId)
	{	
		return contactService.getContactOfUser(userId);
	}
	
	@RequestMapping("/")
	public String welcome()
	{
		return "Welcome To SpringBoot Microservices";
	}
}
