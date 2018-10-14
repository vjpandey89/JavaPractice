package recursionWithDp;

public class CoinChangeProblem {

	public static void main(String[] args) {

		CoinChangeProblem obj = new CoinChangeProblem();
		System.out.println(obj.getNoOfWays(100, new int[] { 50,25, 10, 5, 1 }, 5));

	}

	private int getNoOfWays(int n, int[] coins, int len) {

		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		if (len <= 0 && n >= 1)
			return 0;
		return getNoOfWays(n, coins, len - 1) + getNoOfWays(n - coins[len - 1], coins, len);
	}

}
