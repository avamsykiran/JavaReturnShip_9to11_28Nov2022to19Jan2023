package com.cts.javacollections;

import java.time.LocalTime;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App04 {

	public static void main(String[] args) {
	
		System.out.println("Hello World");
		
		Consumer<Object> c1 = System.out::println;
		c1.accept("Hello World");
		
		BinaryOperator<Integer> sum = (a,b) -> a+b;
		c1.accept(sum.apply(20, 10));
		
		Supplier<String> greet = () -> "Hello";
		c1.accept(greet.get());
		
		Supplier<String> greetAsPerTime = () -> {
			int h = LocalTime.now().getHour();
			
			String greeting = new String();
			if(h>=3 && h<=11) greeting="Good Morning";
			else if(h>=12 && h<=15) greeting = "Good Noon";
			else greeting="Good Evening";
			
			return greeting;
		};
		
		c1.accept(greetAsPerTime.get());
		
		Predicate<Integer> isEven = n -> n%2==0;
		Predicate<Integer> isPositive = n -> n>=0;
		
		c1.accept(isEven.test(45));
		c1.accept(isEven.test(46));
		c1.accept(isPositive.test(-45));
		c1.accept(isPositive.test(45));
		
	}

}
