package com.cts.jpahibdemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("mgr")
//@Table(name="mgrs2")
//@Table(name="mgrs")
public class Manager extends Employee {

	private Double allowence;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(Long empId, String name, double salary,double allowence) {
		super(empId, name, salary);
		this.allowence=allowence;
	}

	public Double getAllowence() {
		return allowence;
	}

	public void setAllowence(Double allowence) {
		this.allowence = allowence;
	}

	@Override
	public String toString() {
		return "Manager [allowence=" + allowence + ", toString()=" + super.toString() + "]";
	}
	
	
}
