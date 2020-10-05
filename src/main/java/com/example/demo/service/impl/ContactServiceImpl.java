package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.component.ContactConverter;
import com.example.demo.entity.Contact;
import com.example.demo.model.ContactModel;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;


@Service("contactServiceImpl")

public class ContactServiceImpl implements ContactService {
	
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	
	@Autowired
	@Qualifier("contactConverter")
	
	private ContactConverter contactConverter;
	
	
	
	@Override
	public ContactModel addContact(ContactModel contactModel ) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContact2ContactModel(contact);
	}



	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List <ContactModel> contactsModel = new ArrayList<ContactModel>();
		for (Contact contact : contacts) {
			contactsModel.add(contactConverter.convertContact2ContactModel(contact));

		}
		return contactsModel;
	}



	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
		
	}
	
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContact2ContactModel(findContactById(id));
	}



	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if(null != contact) {
			contactRepository.delete(findContactById(id));
			
		}
		
		
	}

}
