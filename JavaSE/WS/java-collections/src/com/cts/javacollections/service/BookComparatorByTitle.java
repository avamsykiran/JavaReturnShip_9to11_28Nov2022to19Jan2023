package com.cts.javacollections.service;

import java.util.Comparator;

import com.cts.javacollections.model.Book;

public class BookComparatorByTitle implements Comparator<Book> {

	@Override
	public int compare(Book arg0, Book arg1) {
		return arg0.getTitle().compareTo(arg1.getTitle());
	}

}
