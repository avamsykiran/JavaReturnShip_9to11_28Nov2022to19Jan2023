package com.cts.jpahibdemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("cemp")
//@Table(name = "cemps2")
//@Table(name = "cemps")
public class ContractEmployee extends Employee {

	private Long duration;

	public ContractEmployee() {
		// TODO Auto-generated constructor stub
	}

	public ContractEmployee(Long empId, String name, double salary, Long duration) {
		super(empId, name, salary);
		this.duration = duration;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "ContractEmployee [duration=" + duration + ", toString()=" + super.toString() + "]";
	}
	
	
}
