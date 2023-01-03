package com.cts.loanapp.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cts.loanapp.models.AmortizationRecord;
import com.cts.loanapp.models.Loan;

public class LoanService {

	public void compute(Loan loan) {
		double p = loan.getLoanAmount();
		double n = loan.getEmiCount();
		double r = loan.getRateOfInterest();
		
		//P X R/12) X [(1+R/12) ^N] / [(1+R/12) ^N-1]
		double temp = Math.pow((1+r/12), n);
		loan.setEmiAmount((p*(r/12)*temp)/temp);
		
		loan.setAmortizationTable(new ArrayList<>());
		LocalDate startDate = LocalDate.now();
		
		for(int i=1;i<=loan.getEmiCount();i++) {
			AmortizationRecord row = new AmortizationRecord();
			row.setEmiNumber(i);
			row.setDueDate(startDate.plusMonths(i));
			row.setInterestComponent(p*r);
			row.setPrincipalComponent(loan.getEmiAmount()-row.getInterestComponent());
			loan.getAmortizationTable().add(row);
		}
	}
}
