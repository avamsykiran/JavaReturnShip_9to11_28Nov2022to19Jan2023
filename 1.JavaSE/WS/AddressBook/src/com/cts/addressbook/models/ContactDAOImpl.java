package com.cts.addressbook.models;

import java.util.ArrayList;
import java.util.List;

import com.cts.addressbook.daos.ContactDAO;

public class ContactDAOImpl implements ContactDAO {

	private List<Contact> contacts = new ArrayList<Contact>();
	
	@Override
	public List<Contact> findAll() {
		return contacts;
	}

	@Override
	public Contact findById(int contactId) {
		return contacts.stream().filter( c -> c.getContactId()==contactId).findFirst().orElse(null);
	}

	@Override
	public void deleteById(int contactId) {
		Contact c = findById(contactId);
		if(c!=null) {
			contacts.remove(c);
		}
	}

	@Override
	public Contact save(Contact contact) {
		contacts.add(contact);
		return contact;
	}

}
