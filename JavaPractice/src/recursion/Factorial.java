package recursion;

public class Factorial {

	
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}

	private static int factorial(int n) {
		int sum;
		if(n==1)
			return 1;
		System.out.println("1st n "+n);
		sum=n*factorial(n-1);
		System.out.println("2nd  n "+n);
		return sum;
	}
	
	
}
