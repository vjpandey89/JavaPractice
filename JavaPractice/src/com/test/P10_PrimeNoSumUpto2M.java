package com.test;

public class P10_PrimeNoSumUpto2M {
	
	public static void main(String[] args) {
		
		
		System.out.println("Sum is "+primeSum(2000000L));
	}
	
	public static long primeSum(long n)
	{
		long sum=0,flag=1;
		
		for(long i=2;i<=n;i++)
		{	flag=1;
			for(long j=1;j<=Math.sqrt(i);j++)
			{
			//	System.out.println("Not failing at i and j "+i+"  "+j);
				if((i%j==0)&&(j!=1))
				{
			//		System.out.println("failing at i and j "+i+"  "+j);
					flag=0;
					break;
				}
			}
			if(flag==1)
				sum=sum+i;
		}
		
		return sum;
	}

}
