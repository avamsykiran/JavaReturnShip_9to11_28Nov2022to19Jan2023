package com.cts.jpahibdemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibdemo.entity.Subject;

public class App {

	public static void main(String[] args) {
		
		List<Subject> subjects = new ArrayList<>();
		
		subjects.add(new Subject(null, "Mathemetics"));
		subjects.add(new Subject(null, "Physics"));
		subjects.add(new Subject(null, "Electronics"));
		subjects.add(new Subject(null, "Electricals"));
		subjects.add(new Subject(null, "Medicine"));
		subjects.add(new Subject(null, "Zoology"));
		subjects.add(new Subject(null, "Information Technology"));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		for(Subject s : subjects) {
			em.persist(s);
		}
		txn.commit();
		
		em.close();
		emf.close();
	}

}
