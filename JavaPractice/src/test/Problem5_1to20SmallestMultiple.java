package test;

public class Problem5_1to20SmallestMultiple {
	
	public static void main(String[] args) {
		System.out.println(findSmallestMultiple(20));
	}

	private static int findSmallestMultiple(int n) {
		int multiple=1;
		for(int i=1;i<n;i++)
			multiple=multiple*i/gcd(multiple,i);
		
		return multiple;
	}
	
	
	static int gcd(int a, int b) {
	    return ( 0 == b ) ? a : gcd(b, a%b);
	}
	
	
	
	static long gcd(long a, long b) {
	    while ( 0 != b ) {
	        long temp = a;
	        a = b;
	        b = temp % b;
	    }

	    return a;
	}
	

}
