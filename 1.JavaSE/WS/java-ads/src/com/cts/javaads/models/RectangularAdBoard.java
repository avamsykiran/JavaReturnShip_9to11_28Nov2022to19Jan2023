package com.cts.javaads.models;

public class RectangularAdBoard implements AdBoard {

	private int length;
	private int breadth;

	public RectangularAdBoard(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	@Override
	public double getArea() {
		return length*breadth;
	}

	@Override
	public double getPerimeter() {
		return 2*(length+breadth);
	}

}
