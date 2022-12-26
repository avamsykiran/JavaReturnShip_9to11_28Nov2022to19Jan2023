package com.cts.sdid.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.sdid.service.GreetService;

@Component
public class HomeUI {

	public static final String separator="---------------------------------------------------";
	
	@Autowired
	private GreetService greetService;
	
	public void run() {
		System.out.println("spring di demo app");
		System.out.println(separator);
		
		System.out.println(greetService.greet("All Of You"));
	}
}
