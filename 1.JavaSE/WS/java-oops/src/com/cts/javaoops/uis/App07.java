package com.cts.javaoops.uis;

import java.util.Scanner;

import com.cts.javaoops.exceptions.BankingException;
import com.cts.javaoops.models.BankAccount;
import com.cts.javaoops.service.BankingService;

public class App07 {

	public static void main(String[] args) {

		BankAccount acc = new BankAccount(101, 50000);
		BankingService bService = new BankingService();
		
		Scanner scan = new Scanner(System.in);
		
		String option=new String();
		
		while(!"quit".equalsIgnoreCase(option)) {
			System.out.println("Withdraw/Deposite/Quit? ");
			option = scan.next().toLowerCase();
			
			switch(option) {
			case "withdraw":
				System.out.println("Withdraw Amount? ");
				double withdrawAmt = scan.nextDouble();
				try {
					bService.withdraw(acc, withdrawAmt);
				} catch (BankingException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(acc);
				break;
			case "deposite":
				System.out.println("Deposite Amount? ");
				double depositeAmt = scan.nextDouble();
				try {
					bService.deposite(acc, depositeAmt);
				} catch (BankingException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(acc);
				break;
			case "quit":
				break;
			default:
				System.out.println("Unknown option");
			}
		}
		
		System.out.println("OK, BYE");
		scan.close();
	}
}
