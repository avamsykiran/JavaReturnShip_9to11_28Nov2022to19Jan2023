package com.cts.javathreads;

import com.cts.javathreads.model.Bus;
import com.cts.javathreads.service.ReservationService;

public class App03 {

	public static void main(String[] args) {
		Bus bus = new Bus(23);
		
		Thread t1 = new Thread(new ReservationService(bus, 10),"Krishna");
		Thread t2 = new Thread(new ReservationService(bus, 10),"Rama");
		Thread t3 = new Thread(new ReservationService(bus, 10),"Gopi");
		
		System.out.println("Please wait while booking....");
		t1.start();
		t2.start();
		t3.start();
	}

}
