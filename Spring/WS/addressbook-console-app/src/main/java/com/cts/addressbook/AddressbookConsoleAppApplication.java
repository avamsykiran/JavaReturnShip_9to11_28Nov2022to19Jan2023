package com.cts.addressbook;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressbookConsoleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressbookConsoleAppApplication.class, args);
	}

	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}
}
