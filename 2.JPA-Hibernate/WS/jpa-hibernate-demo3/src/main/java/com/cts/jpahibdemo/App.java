package com.cts.jpahibdemo;

import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibdemo.entity.Address;
import com.cts.jpahibdemo.entity.BankAccount;
import com.cts.jpahibdemo.entity.Department;
import com.cts.jpahibdemo.entity.Employee;

public class App {

	public static void main(String[] args) {
		
		Department d1 = new Department(101L, "Accounts", new TreeSet<>());
		
		Employee emp1 = new Employee(201L, "Vamsy Kiran", 56000.0, new Address("VSP", "AP"),new BankAccount(1234L, "ICICI001") , d1);
		emp1.getSalaryAccount().setHolder(emp1);
		d1.getEmployees().add(emp1);
		
		Department d2 = new Department(102L, "JavaDEv", new TreeSet<>());
		
		Employee emp2 = new Employee(202L, "Bhuvana", 56000.0, new Address("CHN", "TN"),new BankAccount(21234L, "ICICI001") , d2);
		emp2.getSalaryAccount().setHolder(emp2);
		d2.getEmployees().add(emp2);
		
		Employee emp3 = new Employee(203L, "Mangay", 56000.0, new Address("SNG", "TN"),new BankAccount(31234L, "ICICI001") , d2);
		emp3.getSalaryAccount().setHolder(emp3);
		d2.getEmployees().add(emp3);
		
		Department d3 = new Department(103L, "UIDevs", new TreeSet<>());
		
		Employee emp4 = new Employee(204L, "Anand", 56000.0, new Address("MDR", "TN"),new BankAccount(71234L, "ICICI001") , d3);
		emp4.getSalaryAccount().setHolder(emp4);
		d3.getEmployees().add(emp4);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(d1);
		em.persist(d2);
		em.persist(d3);
		txn.commit();
		
		em.close();
		emf.close();
	}

}
