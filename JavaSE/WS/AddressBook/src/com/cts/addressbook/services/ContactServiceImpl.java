package com.cts.addressbook.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.cts.addressbook.daos.ContactDAO;
import com.cts.addressbook.models.Contact;
import com.cts.addressbook.models.ContactDAOImpl;

public class ContactServiceImpl implements ContactService {

	private ContactDAO dao = new ContactDAOImpl();
	
	@Override
	public List<Contact> findAll() {
		return dao.findAll();
	}

	@Override
	public Contact findById(int contactId) {
		return dao.findById(contactId);
	}

	@Override
	public Contact save(Contact contact) {
		Period agePeriod = Period.between(contact.getDateOfBirth(), LocalDate.now());
		contact.setAge(agePeriod.getYears() + (agePeriod.getMonths()/12.0) + (agePeriod.getDays()/365.0));
		return dao.save(contact);
	}

	@Override
	public void deleteById(int contactId) {
		dao.deleteById(contactId);
	}

}
