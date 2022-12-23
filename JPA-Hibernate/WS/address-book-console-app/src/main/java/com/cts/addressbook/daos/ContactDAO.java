package com.cts.addressbook.daos;

import java.util.List;

import com.cts.addressbook.entity.Contact;

public interface ContactDAO {
	List<Contact> findAll();

	Contact findById(int contactId);

	void deleteById(int contactId);

	Contact save(Contact contact);
}
