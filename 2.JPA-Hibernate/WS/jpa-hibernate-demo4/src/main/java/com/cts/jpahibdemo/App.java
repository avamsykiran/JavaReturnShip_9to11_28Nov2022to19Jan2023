package com.cts.jpahibdemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cts.jpahibdemo.entity.Department;
import com.cts.jpahibdemo.entity.Employee;

public class App {

	public static void main(String[] args) {
				
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		
		System.out.println(em.find(Department.class,101L));
		System.out.println(em.find(Department.class,1001L));
		
		final String separator = "--------------------------------------------------------------";
		
		//select * from employees
		TypedQuery<Employee> empsQry1 = em.createQuery("SELECT e FROM Employee e", Employee.class);
		empsQry1.getResultStream().forEach(System.out::println);
		System.out.println(separator);
		
		//select name,salary,addressLine1 from employees
		Query empsQry2 = em.createQuery("SELECT e.name,e.salary,e.address.addressLine1 FROM Employee e");
		List<Object[]> data = empsQry2.getResultList();
		for(Object[] row : data) {
			System.out.println(row[0] +"\t"+row[1]+"\t"+row[2]);
		}
		System.out.println(separator);
		
		//select empId,name,accNum from employees cross join accounts where employees.empId=accounts.holder_empId
		
		Query empsQry3 = em.createQuery("SELECT e.empId,e.name,e.salaryAccount.accNum FROM Employee e");
		List<Object[]> data3 = empsQry3.getResultList();
		for(Object[] row : data3) {
			System.out.println(row[0] +"\t"+row[1]+"\t"+row[2]);
		}
		System.out.println(separator);

		//select empId,name,accNum from employees inner join accounts on employees.empId=accounts.holder_empId

		Query empsQry4 = em.createQuery("SELECT e.empId,e.name,e.salaryAccount.accNum FROM Employee e INNER JOIN e.salaryAccount");
		List<Object[]> data4 = empsQry4.getResultList();
		for(Object[] row : data4) {
			System.out.println(row[0] +"\t"+row[1]+"\t"+row[2]);
		}
		System.out.println(separator);

		//select * from employees where addressLine2=?;
		TypedQuery<Employee> empsQry5 = em.createQuery("SELECT e FROM Employee e WHERE e.address.addressLine2=:adl", Employee.class);
		
		empsQry5.setParameter("adl", "TN");
		empsQry5.getResultStream().forEach(System.out::println);
		System.out.println(separator);
		
		empsQry5.setParameter("adl", "AP");
		empsQry5.getResultStream().forEach(System.out::println);
		System.out.println(separator);
		
		em.close();
		emf.close();
	}

}
