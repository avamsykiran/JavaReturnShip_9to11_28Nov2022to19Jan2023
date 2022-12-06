package com.cts.javaads.models;

public interface AdBoard {
 double getArea();
 double getPerimeter();
 
 public default String getDescription() {
	 return "this is SKML ad agency.";
 }
}
