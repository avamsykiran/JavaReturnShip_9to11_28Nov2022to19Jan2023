package com.cts.javaads.services;

import com.cts.javaads.models.AdBoard;

public class EstimatorService {

	private double paintRate;
	private double borderRate;
	
	public EstimatorService(double paintRate, double borderRate) {
		this.paintRate = paintRate;
		this.borderRate = borderRate;
	}
	
	public double paintingCost(AdBoard adBoard) {
		return adBoard.getArea()*paintRate;
	}
	
	public double borderingCost(AdBoard adBoard) {
		return adBoard.getPerimeter()*borderRate;
	}
}
