package com.cts.jpahibdemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibdemo.entity.ContractEmployee;
import com.cts.jpahibdemo.entity.Employee;
import com.cts.jpahibdemo.entity.Manager;

public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(new Employee(101L, "Vamsy", 45678.0));
		em.persist(new Manager(201L, "Ram", 6789.0, 1234.0));
		em.persist(new ContractEmployee(301L, "Hanuma", 5678.0, 10L));
		txn.commit();
		
		em.close();
		emf.close();
	}

}
