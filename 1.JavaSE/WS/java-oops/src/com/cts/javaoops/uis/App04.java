package com.cts.javaoops.uis;

public class App04 {

	public static void main(String[] args) {
		int[] nums = new int[10];
		
		for(int i=0;i<10;i++) {
			nums[i] = (int)(Math.random()*100);
		}

		int sum=0;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		for(int n : nums) {
			System.out.println(n);
			sum += n;
			min = Math.min(min, n);
			max = Math.max(max, n);
		}
		
		System.out.println("Sum is "+sum);
		System.out.println("Min is "+ min);
		System.out.println("Max is "+max);
	}

}
