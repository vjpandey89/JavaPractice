package recursionWithDp;

import java.util.Arrays;

public class StairPossibilities {

	static int []memo=new int[11];
	
	public static void main(String[] args) {
		Arrays.fill(memo,-1);
		StairPossibilities obj = new StairPossibilities();
		System.out.println(obj.getNoOfWays(10,memo));
		
		
	}

	private int getNoOfWays(int n,int []memo) {

		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		
		if(memo[n]!=-1)
			return memo[n];
		memo[n]=getNoOfWays((n - 3),memo) + getNoOfWays((n - 2),memo) + getNoOfWays((n - 1),memo);
		return memo[n];
	}

}
