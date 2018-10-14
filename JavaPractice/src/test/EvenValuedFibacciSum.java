package test;

public class EvenValuedFibacciSum {

	static long sum;

	public static void main(String[] args) {

		int prev = 1, current = 2, next = 0;
		// method1
		/*
		 * for ( int i=2;current<4000000;i++) { if(current%2==0)
		 * sum=sum+current; next=prev+current; prev=current; current=next; }
		 */

		// System.out.println("Sum is "+sum);
		
		
		//Method 2 with recursion
		evenFib(3);
		System.out.println("final is : " + sum);
	}

	static long evenFib(long n) {
		long evenNo = 0;
		if (n < 1) {
			return n;
		}

		if (n == 1) {
			sum = sum + 2;
			return 2;

		}
		evenNo = ((4 * evenFib(n - 1)) + evenFib(n - 2));
		sum = sum + evenNo;
		return evenNo;
	}

}
