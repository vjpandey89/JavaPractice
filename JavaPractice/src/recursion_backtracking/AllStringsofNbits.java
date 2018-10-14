package recursion_backtracking;

public class AllStringsofNbits {
	
	static int a[]=new int[2];
	public static void main(String[] args) {
		binary(2);
		
	}
	
	public static void binary(int n)
	{
		
		if(n<1)
		{
			System.out.println(" \n");
			for(int i:a)
				System.out.print(i);
		}	
		else
		{
			a[n-1]=0;
			binary(n-1);
			a[n-1]=1;
			binary(n-1);
			
		}
		
	}

}
