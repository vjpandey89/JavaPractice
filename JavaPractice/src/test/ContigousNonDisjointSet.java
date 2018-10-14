package test;

import java.util.ArrayList;
import java.util.List;

public class ContigousNonDisjointSet {
	
	public static void main(String[] args) {
		int[] arr = new int[] { 6,1,4,6,3,2,7,4 };

		System.out.println(maxSumOf2KArr(arr, 3,2));
	}

	private static char[] maxSumOf2KArr(int[] arr, int k, int l) {
		
		int []sum=new int[arr.length];
		for(int i=0;i<=arr.length-k-l;i++)
		{
			for(int j=i;j<k+i;j++)
			{
				sum[i]=sum[i]+arr[j];
			}
		}
		for(int i:sum)
			System.out.print(i+" ");
		
		
		for(int i=arr.length;i>k+l;i--)
		{
			for(int j=i;j>i-l;j--)
			{
				
			}
		}
		
			
		
		
		return null;
	}
	
	

}
