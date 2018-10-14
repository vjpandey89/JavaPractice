package com.test;

public class Problem9 {
	
	public static void main(String[] args) {
		System.out.println(pythogorastriplet(1000));
	}

	
	
	public static int pythogorastriplet(int sum)
	{
		int i=0,j = 0,k = 0;	
		for( i=1;i<1000;i++)
			for(j=i;j<1000;j++)
				for(k=i;k<1000;k++)
				{
					
					if((i*i)+(j*j)==(k*k))
					{
						System.out.println("triplets "+i+ "  "+j+"  "+" "+k);
						if(i+j+k==1000)
						{
							System.out.println("final "+i+ "  "+j+"  "+" "+k);
							System.exit(0);
						}
						break;
					}
				}
		
		return (i*j*k);
	}
	
}
