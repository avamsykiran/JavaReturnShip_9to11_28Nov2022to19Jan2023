package com.cts.loanapp.models;

import java.time.LocalDate;

public class AmortizationRecord {

	private int emiNumber;
	private double interestComponent;
	private double principalComponent;
	private LocalDate dueDate;

	public int getEmiNumber() {
		return emiNumber;
	}

	public void setEmiNumber(int emiNumber) {
		this.emiNumber = emiNumber;
	}

	public double getInterestComponent() {
		return interestComponent;
	}

	public void setInterestComponent(double interestComponent) {
		this.interestComponent = interestComponent;
	}

	public double getPrincipalComponent() {
		return principalComponent;
	}

	public void setPrincipalComponent(double principalComponent) {
		this.principalComponent = principalComponent;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "AmortizationRecord [emiNumber=" + emiNumber + ", interestComponent=" + interestComponent
				+ ", principalComponent=" + principalComponent + ", dueDate=" + dueDate + "]";
	}

}
