package com.cts.javathreads;

import com.cts.javathreads.service.NumberSeries;

public class App02 {

	public static void main(String[] args) {
		NumberSeries ns1 = new NumberSeries(1, 10);
		NumberSeries ns2 = new NumberSeries(100, 110);
		
		//ns1.run();
		//ns2.run();
		
		Thread t1 = new Thread(ns1, "ThreadOne");
		Thread t2 = new Thread(ns2, "ThreadTwo");
		
		t1.start();
		t2.start();
	}

}
