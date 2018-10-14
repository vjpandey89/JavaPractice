package test;

public class SumDivisibleBy3or5 {

	public static void main(String[] args) {

		int sum = 0,n=999;
		// Method 1
		/*for (int i = 1; i < n; i++) {

			if ((i % 5 == 0) || (i % 3 == 0)) {
				sum = sum + i;
				System.out.print(" "+i);
			}

		//output Sum is 233168
		}*/
		

		
		//Method 2
		sum=sumDivisiblByN(3,n)+sumDivisiblByN(5,n)-sumDivisiblByN(15,n);
		System.out.println("Sum is"+sum);
		
		
	}

	private static int sumDivisiblByN(int i,int n) {
		
		return i*(n/i)*(n/i+1)/2;
		
	}

}
