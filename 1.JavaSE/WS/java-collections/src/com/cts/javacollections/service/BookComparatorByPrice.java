package com.cts.javacollections.service;

import java.util.Comparator;

import com.cts.javacollections.model.Book;

public class BookComparatorByPrice implements Comparator<Book> {

	@Override
	public int compare(Book arg0, Book arg1) {
		return ((Double)arg0.getPrice()).compareTo(arg1.getPrice());
	}

}
