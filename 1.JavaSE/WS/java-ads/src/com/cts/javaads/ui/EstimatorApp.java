package com.cts.javaads.ui;

import com.cts.javaads.models.CircularAdboard;
import com.cts.javaads.models.RectangularAdBoard;
import com.cts.javaads.services.EstimatorService;

public class EstimatorApp {

	public static void main(String[] args) {

		EstimatorService es = new EstimatorService(10, 3);
		
		RectangularAdBoard rb = new RectangularAdBoard(12, 5);
		CircularAdboard cb = new CircularAdboard(11);
		
		System.out.println(es.paintingCost(rb));
		System.out.println(es.borderingCost(rb));
		System.out.println(es.paintingCost(cb));
		System.out.println(es.borderingCost(cb));
	}

}
