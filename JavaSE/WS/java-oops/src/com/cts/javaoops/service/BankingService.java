package com.cts.javaoops.service;

import com.cts.javaoops.exceptions.BankingException;
import com.cts.javaoops.models.BankAccount;

public class BankingService {

	public static final double MIN_BAL=5000;
	
	public void deposite(BankAccount acc,double amount) throws BankingException {
		if(amount<=0)
			throw new BankingException("Negeative or Zero amount can not be deposited");
	
		acc.setBalance(acc.getBalance()+amount);
	}

	public void withdraw(BankAccount acc,double amount) throws BankingException {
		if(amount<=0)
			throw new BankingException("Negeative or Zero amount can not be withdrawn");
		
		if(acc.getBalance()-amount<MIN_BAL)
			throw new BankingException("Insufficient Funds");
	
		acc.setBalance(acc.getBalance()-amount);
	}
}
