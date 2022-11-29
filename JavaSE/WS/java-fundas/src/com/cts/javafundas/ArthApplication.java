package com.cts.javafundas;

import java.util.Scanner;

public class ArthApplication {

	public static void main(String[] args) {
		
		Scanner kbin = new Scanner(System.in);
		
		System.out.println("What is your first operand?");
		int x = kbin.nextInt();
		System.out.println("What is your second operand?");
		int y = kbin.nextInt();
		
		System.out.println("Sum is " + (x+y));
		System.out.println("Dif is " + (x-y));
		System.out.println("Prd is " + (x*y));
		System.out.println("Rem is " + (x%y));
		System.out.println("Qut is " + (x/y));
	}

}
