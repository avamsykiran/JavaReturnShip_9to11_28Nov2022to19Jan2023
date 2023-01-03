package com.cts.jpahibdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee implements Comparable<Employee>{

	@Id
	private Long empId;
	private String name;
	private Double salary;

	@Embedded
	private Address address;
	
	@OneToOne(mappedBy = "holder",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private BankAccount salaryAccount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Department dept;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String name, Double salary, Address address, BankAccount salaryAccount,
			Department dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.salaryAccount = salaryAccount;
		this.dept = dept;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BankAccount getSalaryAccount() {
		return salaryAccount;
	}

	public void setSalaryAccount(BankAccount salaryAccount) {
		this.salaryAccount = salaryAccount;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	/*
	 * @Override public String toString() { return "Employee [empId=" + empId +
	 * ", name=" + name + ", salary=" + salary + ", address=" + address +
	 * ", salaryAccount=" + salaryAccount + ", dept=" + dept + "]"; }
	 */

	
	
	@Override
	public int compareTo(Employee o) {
		return this.empId==null?1:this.empId.compareTo(o.empId);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", address=" + address + "]";
	}
}
