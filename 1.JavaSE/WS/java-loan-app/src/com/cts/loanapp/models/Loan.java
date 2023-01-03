package com.cts.loanapp.models;

import java.util.List;

public class Loan {

	private double loanAmount;
	private double rateOfInterest;
	private double emiCount;
	private double emiAmount;
	private List<AmortizationRecord> amortizationTable;

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public double getEmiCount() {
		return emiCount;
	}

	public void setEmiCount(double emiCount) {
		this.emiCount = emiCount;
	}

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public List<AmortizationRecord> getAmortizationTable() {
		return amortizationTable;
	}

	public void setAmortizationTable(List<AmortizationRecord> amortizationTable) {
		this.amortizationTable = amortizationTable;
	}

	@Override
	public String toString() {
		return "Loan [loanAmount=" + loanAmount + ", rateOfInterest=" + rateOfInterest + ", emiCount=" + emiCount
				+ ", emiAmount=" + emiAmount + ", amortizationTable=" + amortizationTable + "]";
	}

}
