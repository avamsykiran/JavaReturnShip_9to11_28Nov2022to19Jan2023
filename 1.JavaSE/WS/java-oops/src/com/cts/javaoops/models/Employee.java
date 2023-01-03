package com.cts.javaoops.models;

public class Employee {

	private long empId;
	private String name;
	private double basic;

	public Employee(long empId, String name, double basic) {
		this.empId = empId;
		this.name = name;
		this.basic = basic;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	@Override
	public String toString() {
		return "empId=" + empId + ", name=" + name + ", basic=" + basic;
	}

}
