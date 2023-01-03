package com.cts.sdid.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.sdid.service.GreetService;

@Component
public class HomeUI {

	@Value("${app.name}")
	private String appName;
	
	@Value("${app.separator}")
	private String separator;
	
	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService1;
	
	@Autowired
	@Qualifier("greetServiceAdvancedImpl")
	private GreetService greetService2;
	
	@Autowired
	private Scanner scanner;
	
	public void run() {
		System.out.println(appName);
		System.out.println(separator);
		
		System.out.println("Whats your name?");
		String unm = scanner.next();
		System.out.println(greetService1.greet(unm));
		System.out.println(greetService2.greet(unm));
	}
}
