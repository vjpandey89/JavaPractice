package test;



public class GreatestPrimeFactor {
	
	public static void main(String[] args) {
		long n=600851475143L;
		System.out.println(findGPF(n));
		
		
	}
	
	private static int findGPF(long n) {
		int pf = 2;
		
		while(n>pf)
		{
			if(n%pf==0)
			{
				n=n/pf;
				pf=2;
			}
			pf++;
		}
		return pf;
		
	}

	

}
