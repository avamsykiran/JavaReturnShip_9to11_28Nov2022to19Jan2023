package com.cts.addressbook.services;

import java.util.List;

import com.cts.addressbook.entity.Contact;

public interface ContactService {
	List<Contact> findAll();
	Contact findById(int contactId);
	Contact save(Contact contact);
	void deleteById(int contactId);
}
