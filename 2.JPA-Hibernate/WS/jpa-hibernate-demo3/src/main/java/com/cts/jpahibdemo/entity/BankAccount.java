package com.cts.jpahibdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class BankAccount {

	@Id
	private Long accNum;
	private String IFSCCode;
	
	@OneToOne
	@JoinColumn
	private Employee holder;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankAccount(Long accNum, String iFSCCode) {
		super();
		this.accNum = accNum;
		IFSCCode = iFSCCode;
	}

	public Long getAccNum() {
		return accNum;
	}

	public void setAccNum(Long accNum) {
		this.accNum = accNum;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public Employee getHolder() {
		return holder;
	}

	public void setHolder(Employee holder) {
		this.holder = holder;
	}

	@Override
	public String toString() {
		return "BankAccount [accNum=" + accNum + ", IFSCCode=" + IFSCCode + "]";
	}
	
	
}
