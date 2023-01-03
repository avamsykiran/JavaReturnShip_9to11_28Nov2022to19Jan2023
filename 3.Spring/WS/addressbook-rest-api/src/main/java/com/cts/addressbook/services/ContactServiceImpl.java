package com.cts.addressbook.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.addressbook.entity.Contact;
import com.cts.addressbook.repo.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo dao;
	
	@Override
	public List<Contact> findAll() {
		return dao.findAll();
	}

	@Override
	public Contact findById(int contactId) {
		return dao.findById(contactId).orElse(null);
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
