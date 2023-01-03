package com.cts.jpahibdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicalTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long testId;
	private String testName;
	private Double testFee;
	
	public MedicalTest() {
		
	}

	public MedicalTest(Long testId, String testName, Double testFee) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testFee = testFee;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Double getTestFee() {
		return testFee;
	}

	public void setTestFee(Double testFee) {
		this.testFee = testFee;
	}

	@Override
	public String toString() {
		return "MedicalTest [testId=" + testId + ", testName=" + testName + ", testFee=" + testFee + "]";
	}
	
	 
}
