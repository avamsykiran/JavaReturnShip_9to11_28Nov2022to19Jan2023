package com.cts.javaoops.uis;

import java.util.Scanner;

public class App05 {

	public static void main(String[] args) {

		Scanner kbin = new Scanner(System.in);
		
		System.out.println("Enter a string: ");
		String str = kbin.nextLine();
		
		/*String rev = new String();
		
		for(int i=str.length()-1;i>=0;i--) {
			rev += str.charAt(i);
		}*/
		
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String rev = new String(sb);
		
		System.out.println(rev);
		
		if(str.equalsIgnoreCase(rev)) {
			System.out.println("Its a pallendrom");
		}else {
			System.out.println("Its not a pallendrome");
		}
	}

}
