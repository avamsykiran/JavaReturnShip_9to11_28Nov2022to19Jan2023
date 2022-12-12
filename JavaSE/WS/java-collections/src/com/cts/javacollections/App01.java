package com.cts.javacollections;

import com.cts.javacollections.service.DataAlgorithms;

public class App01 {

	public static void main(String[] args) {
		
		Integer nums[] = new Integer[] {10,20,30,50,40,77,98};
		String nanes[]=new String[] {"Vamsy","Amit","Sarla","Venu"};
		
		DataAlgorithms<String> da1 = new DataAlgorithms<String>();
		da1.search(nanes, "Venu");
		da1.search(nanes, "venu");

		DataAlgorithms<Integer> da2 = new DataAlgorithms<Integer>();
		da2.search(nums,21);
		da2.search(nums,77);
	}

}
