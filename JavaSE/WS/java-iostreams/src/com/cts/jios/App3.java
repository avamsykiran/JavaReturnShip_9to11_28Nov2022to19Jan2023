package com.cts.jios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cts.jios.models.Contact;

public class App3 {

	public static void main(String[] args) {
		final String fileName = "./contacts.csv";
		
		Path filePath = Paths.get(fileName);
		
		try {
			if(Files.notExists(filePath)) {
				System.out.println("No such file found");
			}else {
				List<String> lines = Files.readAllLines(filePath);
				
				Function<String, Contact> convertStringToContact = str -> {
					Contact c = new Contact();
					if(str!=null) {
						String cols[] = str.split(",");
						c.setFirstName(cols[0]);
						c.setLastName(cols[1]);
						c.setMobile(cols[2]);
						c.setMailId(cols[3]);
						c.setDateOfBirth(LocalDate.parse(cols[4]));
						Period agePeriod = Period.between(c.getDateOfBirth(), LocalDate.now());
						double age = agePeriod.getYears() + (agePeriod.getMonths()/12.0) + (agePeriod.getDays()/365.0);
						c.setAge(age);
					}
					return c;
				};
				
				List<Contact> contacts = lines.stream().map(convertStringToContact).collect(Collectors.toList());
				contacts.stream().forEach(System.out::println);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
