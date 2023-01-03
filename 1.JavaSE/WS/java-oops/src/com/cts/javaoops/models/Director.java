package com.cts.javaoops.models;

public class Director extends Manager {
	private double share;

	public Director(long empId, String name, double basic, double allowence,double share) {
		super(empId, name, basic, allowence);
		this.share=share;
	}

	public double getShare() {
		return share;
	}

	public void setShare(double share) {
		this.share = share;
	}

	@Override
	public String toString() {
		return super.toString()+"share=" + share;
	}
	
	
}
