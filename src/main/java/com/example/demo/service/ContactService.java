package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Contact;
import com.example.demo.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
	
	public abstract ContactModel findContactByIdModel(int id);



}
