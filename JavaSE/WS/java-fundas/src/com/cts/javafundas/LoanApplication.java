package com.cts.javafundas;

import java.util.Scanner;

public class LoanApplication {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("How much did you borrow?");
		double principal = scan.nextDouble();
		System.out.println("What was the rate of inteest per anum?");
		double rate = scan.nextDouble();
		System.out.println("How long will you take to repay (in years)?");
		double time = scan.nextDouble();
		
		double simpleInterest = (principal*rate*time)/100; //compute the simple interest
		
		System.out.println("SimpleInterest: "+simpleInterest);
	}

}
