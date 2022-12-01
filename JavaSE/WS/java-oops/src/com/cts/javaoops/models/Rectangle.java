package com.cts.javaoops.models;

public class Rectangle {
	
	private static int count;
	
	private int length;
	private int breadth;
	
	static {
		System.out.println("This is a static block#1.");
	}
	
	static {
		System.out.println("This is a static block#2.");
	}
	
	public Rectangle(){
		count++;
		System.out.println("A rectangle#"+count+" is created.");
	}

	public Rectangle(int length, int breadth) {
		this();
		this.length = length;
		this.breadth = breadth;
	}
	
	public Rectangle(Rectangle r) {
		this(r.length,r.breadth);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	
	public int getArea() {
		return this.length*this.breadth;
	}
	
	public static Rectangle add(Rectangle x,Rectangle y) {
		return new Rectangle(x.length+y.length, x.breadth+y.breadth);
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", breadth=" + breadth + "]";
	}
	
	
}
