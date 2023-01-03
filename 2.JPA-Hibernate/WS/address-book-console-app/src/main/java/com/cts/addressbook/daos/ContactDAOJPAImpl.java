package com.cts.addressbook.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cts.addressbook.entity.Contact;
import com.cts.addressbook.util.EntityManagerUtility;

public class ContactDAOJPAImpl implements ContactDAO {
	
	private EntityManager getEntityManager() {
		return EntityManagerUtility.getEntityManagerFactory().createEntityManager();
	}
	
	@Override
	public List<Contact> findAll() {
		EntityManager em =getEntityManager();
		TypedQuery<Contact> qry = em.createQuery("SELECT c FROM Contact c",Contact.class);
		List<Contact> contacts = qry.getResultList();
		em.close();
		return contacts;
	}

	@Override
	public Contact findById(int contactId) {
		EntityManager em =getEntityManager();
		Contact contact = em.find(Contact.class, contactId);
		em.close();
		return contact;
	}

	@Override
	public void deleteById(int contactId) {
		EntityManager em =getEntityManager();
		Contact contact = em.find(Contact.class, contactId);
		if(contact!=null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(contact);
			t.commit();
		}
		em.close();
	}

	@Override
	public Contact save(Contact contact) {
		EntityManager em =getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(contact);
		t.commit();
		em.close();
		return contact;
	}

}
