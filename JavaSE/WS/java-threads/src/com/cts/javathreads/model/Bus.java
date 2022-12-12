package com.cts.javathreads.model;

public class Bus {

	private int seats;
	private int lastReservedSeat;
	
	public Bus(int seats) {
		this.seats = seats;
		this.lastReservedSeat=0;
	}
	
	public int bookASeat() {
		this.lastReservedSeat++;
		return this.lastReservedSeat;
	}
	
	public boolean areSeatsAvailable(int required) {
		int balance = seats-lastReservedSeat;
		return balance>=required;
	}
}
