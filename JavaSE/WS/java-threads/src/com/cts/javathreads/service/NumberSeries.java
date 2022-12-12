package com.cts.javathreads.service;

public class NumberSeries implements Runnable {

	private int lowerLimit;
	private int upperLimit;

	public NumberSeries(int lowerLimit, int upperLimit) {
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	@Override
	public void run() {
		String thName = Thread.currentThread().getName();
		for(int i=lowerLimit;i<=upperLimit;i++) {
			System.out.println(thName +":>> " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
