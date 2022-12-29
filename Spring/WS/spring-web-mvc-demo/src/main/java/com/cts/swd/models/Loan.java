package com.cts.swd.models;

public class Loan {

	private double principal;
	private double roi;
	private double timePeriod;
	private double simpleInterest;
	
	public Loan() {}

	public Loan(double principal, double roi, double timePeriod, double simpleInterest) {
		super();
		this.principal = principal;
		this.roi = roi;
		this.timePeriod = timePeriod;
		this.simpleInterest = simpleInterest;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

	public double getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(double timePeriod) {
		this.timePeriod = timePeriod;
	}

	public double getSimpleInterest() {
		return simpleInterest;
	}

	public void setSimpleInterest(double simpleInterest) {
		this.simpleInterest = simpleInterest;
	}
	
	
}
