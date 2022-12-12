package com.cts.javacollections.service;

public class DataAlgorithms<T> {
	public void search(T[] array, T searchElement) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(searchElement)) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			System.out.println("Element is not found");
		} else {
			System.out.println("Element found @ " + index);
		}
	}
}
