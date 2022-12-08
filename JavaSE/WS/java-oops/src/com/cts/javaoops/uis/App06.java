package com.cts.javaoops.uis;

import java.util.Scanner;

public class App06 {

	private static Scanner scan = new Scanner(System.in);
	
	private static int readInt() {
		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("Expecting a integer value...");
		}
		return scan.nextInt();
		
	}
	
	public static void main(String[] args) {
		
		int n1=0;
		int n2=0;
		
		System.out.println("Enter a devident: ");
		n1=readInt();
		System.out.println("Enter a divisor: ");
		n2=readInt();
		
		if(n2!=0) {
			System.out.println(n1/n2);
		}else {
			System.out.println("Zero is not an acceptable divisor");
		}
		
		System.out.println("OK Bye!");
	}

}
