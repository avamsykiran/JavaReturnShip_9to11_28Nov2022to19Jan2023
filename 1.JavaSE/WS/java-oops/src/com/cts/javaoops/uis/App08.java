package com.cts.javaoops.uis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.cts.javaoops.exceptions.BankingException;
import com.cts.javaoops.models.BankAccount;
import com.cts.javaoops.service.BankingService;

public class App08 {

	public static void main(String[] args) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate today = LocalDate.now();
		System.out.println(today);
		System.out.println(today.format(formatter));

		Scanner scan = new Scanner(System.in);

		System.out.println("DOB: (dd-MMM-yyyy): ");
		LocalDate dob = LocalDate.parse(scan.next(), formatter);
		
		System.out.println("Age is " + Period.between(dob, today).getYears());
		
		scan.close();
		
		LocalDateTime nowInIndia = LocalDateTime.now();
		ZonedDateTime nowInAustralia = ZonedDateTime.now(ZoneId.of("GMT+10:30"));
	
		System.out.println(nowInIndia);
		System.out.println(nowInAustralia);
		
		
	}
}
