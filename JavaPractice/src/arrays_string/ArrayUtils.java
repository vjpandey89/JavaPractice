package arrays_string;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayUtils {

	public static void print1DArray(int arr[]) {

		Arrays.stream(arr).forEach(System.out::println);

	
	}

	public static void print2DArray(int[][] arr) {

		Stream.of(arr).flatMap(Stream::of).forEach(System.out::println);

	}
	
	
	public static int findGCD(int x,int y)
	{
		int gcd=1,smallerNo;
		if(x<y)
			smallerNo=x;
		else
			smallerNo=y;	
		for(int i=1;i<=smallerNo;i++)
		{
			if(x%i==0&&y%i==0)
				gcd=i;
		}
		return gcd;
	}
	
	public static void main(String[] args) {
		System.out.println(findGCD(2, 9));
	}

}
