package com.cts.swd.service;

import org.springframework.stereotype.Service;

import com.cts.swd.models.Loan;

@Service
public class LoanService {

	public void compute(Loan loan) {
		loan.setSimpleInterest((loan.getPrincipal()*loan.getRoi()*loan.getTimePeriod())/100.0);
	}
}
