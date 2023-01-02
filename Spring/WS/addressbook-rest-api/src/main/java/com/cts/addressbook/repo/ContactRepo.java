package com.cts.addressbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.addressbook.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact,Integer> {
	
}
