package com.cts.javaoops.uis;

import com.cts.javaoops.models.Rectangle;

public class App01 {

	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(10,25);
		Rectangle r3 = new Rectangle(r2);
		Rectangle r4 = r1;
		
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
		System.out.println(r3.hashCode());
		System.out.println(r4.hashCode());
		
		System.out.println(r1.getLength() + "\t" + r1.getBreadth());
		System.out.println(r2.getLength() + "\t" + r2.getBreadth());
		System.out.println(r3.getLength() + "\t" + r3.getBreadth());
		System.out.println(r4.getLength() + "\t" + r4.getBreadth());
		
		r1.setLength(100);
		r2.setLength(200);
		
		System.out.println("---------------------------------------------------------------------");

		System.out.println(r1.getLength() + "\t" + r1.getBreadth());
		System.out.println(r2.getLength() + "\t" + r2.getBreadth());
		System.out.println(r3.getLength() + "\t" + r3.getBreadth());
		System.out.println(r4.getLength() + "\t" + r4.getBreadth());
		
		Rectangle r5 = Rectangle.add(r1, r2);
		System.out.println(r5.getLength() + "\t" + r5.getBreadth());
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r5);
	}

}
