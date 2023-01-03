package com.cts.sdid.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.sdid.service.Counter;
import com.cts.sdid.service.GreetService;

@Component
public class HomeUI implements CommandLineRunner {

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
	
	@Autowired
	private Counter counter1;
	
	@Autowired
	private Counter counter2;
		
	@Override
	public void run(String... args) throws Exception {
		System.out.println(appName);
		System.out.println(separator);
		
		System.out.println("Whats your name?");
		String unm = scanner.next();
		System.out.println(greetService1.greet(unm));
		System.out.println(greetService2.greet(unm));
		
		System.out.println(counter1.getCount());
		System.out.println(counter1.getCount());
		System.out.println(counter2.getCount());
		System.out.println(counter2.getCount());
	}
}
