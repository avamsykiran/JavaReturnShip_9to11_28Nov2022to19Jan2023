package com.cts.javathreads.service;

import com.cts.javathreads.model.Bus;

public class ReservationService implements Runnable {

	private Bus bus;
	private int requiredSeats;

	public ReservationService(Bus bus, int requiredSeats) {
		this.bus = bus;
		this.requiredSeats = requiredSeats;
	}

	@Override
	public void run() {
		synchronized (bus) {
			while (requiredSeats > 0 && bus.areSeatsAvailable(requiredSeats)) {
				bus.bookASeat();
				requiredSeats--;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		String thName = Thread.currentThread().getName();

		if (requiredSeats == 0) {
			System.out.println("All seats reservedc for " + thName);
		} else {
			System.out.println("Ran out of seats! Could not reserve " + requiredSeats + " seats for " + thName);
		}
	}

}
