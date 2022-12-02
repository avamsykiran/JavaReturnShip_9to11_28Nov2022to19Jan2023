package com.cts.javaoops.models;

public class Manager extends Employee {
	private double allowence;

	public Manager(long empId, String name, double basic,double allowence) {
		super(empId, name, basic);
		this.allowence=allowence;
	}

	public double getAllowence() {
		return allowence;
	}

	public void setAllowence(double allowence) {
		this.allowence = allowence;
	}

	@Override
	public String toString() {
		return super.toString() + ",allowence=" + allowence;
	}
	
	
}
