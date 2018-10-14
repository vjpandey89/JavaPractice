package com.test;

public class Problem6 {
	
	public static void main(String[] args) {
		System.out.println(diffBetweenSumSquare(100));
		//output 25164150
	}

	private static int diffBetweenSumSquare(int n) {
		
		int sum,sum_square;
		sum=n*(n+1)/2;
		sum_square=(((2*n)+1)*(n+1)*(n))/6;
	//	System.out.println("sum is "+sum+" square sum is "+sum_square);
		
		return (sum*sum)-sum_square;
	}
	
	
	

}
