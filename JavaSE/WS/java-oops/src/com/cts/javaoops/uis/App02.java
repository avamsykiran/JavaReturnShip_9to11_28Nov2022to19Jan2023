package com.cts.javaoops.uis;

import com.cts.javaoops.models.Director;
import com.cts.javaoops.models.Employee;
import com.cts.javaoops.models.Manager;

public class App02 {

	public static void main(String[] args) {
		Employee emp = new Employee(101,"Vamsy",65000);
		System.out.println(emp);
		Manager mgr = new Manager(102, "Srinivas", 76000, 4000);
		System.out.println(mgr);
		Director dir = new Director(201, "Suseela", 1_20_000, 6_000, 12.25);
		System.out.println(dir);
		
		System.out.println(emp instanceof Employee);
		System.out.println(mgr instanceof Employee);
		System.out.println(dir instanceof Employee);
		System.out.println(emp instanceof Manager);
		System.out.println(mgr instanceof Manager);
		System.out.println(dir instanceof Manager);
	}

}
