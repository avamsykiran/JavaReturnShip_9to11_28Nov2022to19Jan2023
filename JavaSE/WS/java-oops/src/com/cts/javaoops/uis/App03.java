package com.cts.javaoops.uis;

import com.cts.javaoops.models.Rectangle;

public class App03 {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(10,25);
		Rectangle r3 = new Rectangle(r2);
		Rectangle r4 = r2;
		
		System.out.println(r1.equals(r2));
		System.out.println(r3.equals(r2));
		System.out.println(r4.equals(r2));
		
		
	}

}
