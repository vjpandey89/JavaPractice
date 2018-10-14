package arraysAndstring;

public class SearchingandSorting {
	
	
	public static String binarySearch(int[] arr,int size,int item)
	{
		int low,high,med;
		low=0;
		high=size-1;
		
		while(low<high)
		{
			med=low+(high-low)/2;
			if(arr[med]==item)
				return "Number found at position "+med;
			else if(arr[med]<item)
				low=med+1;
			else
				high=med-1;
		}
		return "item not found";
		
	}
	
	public static void main(String[] args) {
		int arr[]={1,2,3,4,5,6,7,8,9};
		
		System.out.println(binarySearch(arr,9,3));
		
	}

}
