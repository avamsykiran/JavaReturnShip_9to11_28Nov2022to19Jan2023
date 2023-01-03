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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + breadth;
		result = prime * result + length;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (breadth != other.breadth)
			return false;
		if (length != other.length)
			return false;
		return true;
	}
	
	
}
