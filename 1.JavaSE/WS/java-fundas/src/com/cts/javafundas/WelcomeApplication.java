package com.cts.javafundas;

import java.util.Scanner;

public class WelcomeApplication {

	public static void main(String[] args) {
	
		Scanner kbin = new Scanner(System.in);
		
		if(args.length==0) {
			System.out.println("Hello World!");
		}else {
			for(String arg : args) {
				System.out.println("Hello " + arg);
			}
		}
		
		System.out.println("Whats your name? ");
		String userName = kbin.next();
		
		System.out.println("How old are you? ");
		double age = kbin.nextDouble();
		
		System.out.println("Hello "+userName + " you are just "+age+" years of age.");
	}
}
