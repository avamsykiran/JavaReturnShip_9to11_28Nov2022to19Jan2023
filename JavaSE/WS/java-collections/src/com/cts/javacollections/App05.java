package com.cts.javacollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import com.cts.javacollections.model.Book;
import com.cts.javacollections.service.BookComparatorByPrice;
import com.cts.javacollections.service.BookComparatorByTitle;

public class App05 {

	public static void main(String[] args) {
		List<Book> books=new ArrayList<>();
		
		books.add(new Book(110, "Let US C", 456.0));
		books.add(new Book(100, "Let US C++", 586.0));
		books.add(new Book(111, "Java Complete Reerence", 856.0));
		books.add(new Book(101, "Hounds Of Baskervalli", 156.0));
		books.add(new Book(112, "Deep in the woods", 56.0));
		books.add(new Book(117, "Wings Of Fire", 1056.0));
		books.add(new Book(114, "Sindhubad Adventures", 256.0));
		books.add(new Book(116, "Adventure of Narnia", 496.0));
		books.add(new Book(115, "Head First Java", 356.0));
		books.add(new Book(113, "Pirate of carabian", 256.0));
		books.add(new Book(110, "You can win", 956.0));
	
		books.stream().forEach( b -> {b.setPrice(b.getPrice() + (b.getPrice()*0.02));} );
		books.stream().forEach(System.out::println);
		
		System.out.println("------------------------------------------------------------------------");
		Optional<Book> cheapestBook = books.stream().reduce( (b1,b2) -> b1.getPrice()<b2.getPrice()?b1:b2 );
		if(cheapestBook.isPresent()) {
			System.out.println(cheapestBook.get());
		}
		
		System.out.println("------------------------------------------------------------------------");
		Optional<Book> result = books.stream().reduce( (b1,b2) -> b1.getTitle().length()>b2.getTitle().length()?b1:b2 );
		if(result.isPresent()) {
			System.out.println(result.get());
		}
		
		System.out.println("------------------------------------------------------------------------");
		books.stream().filter( b -> b.getPrice()<=500 ).forEach(System.out::println);
		
		System.out.println("-------------------------------------------------------------------------");
		books.stream().map(b -> b.getTitle()).forEach(System.out::println);
	}

}



