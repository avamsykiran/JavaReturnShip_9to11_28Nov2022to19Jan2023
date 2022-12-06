package com.cts.javaads.models;

public class CircularAdboard implements AdBoard {

	public static final double PI=3.14;
	
	private int radius;

	public CircularAdboard(int radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return PI*radius*radius; 
	}

	@Override
	public double getPerimeter() {
		return 2*PI*radius;
	}

}
