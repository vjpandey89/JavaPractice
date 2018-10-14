package arrays_string;

public class SubArrayOverlapping {
	public static void main(String[] args) {
		int[] arr = new int[] { 6, 8, 17, 4, 2, 3, 11, 6, 1, 10, 0, 10, 49, -43, 81, 12, 0, 23 };

		System.out.println(maxSumOf2KArr(arr, 3));
	}

	public static int maxSumOf2KArr(int[] arr, int k) {
		int[] rollingKSum = getRollingKSum(arr, k);
		int maxL = Integer.MIN_VALUE, maxSum = Integer.MIN_VALUE;
		for (int i = k; i < rollingKSum.length; i++) {
			maxL = Math.max(maxL, rollingKSum[i - k]);
			maxSum = Math.max(maxSum, maxL + rollingKSum[i]);
		}

		return maxSum;
	}

	public static int[] getRollingKSum(int[] arr, int k) {
		int[] ret = new int[arr.length - k + 1];
		int sum = 0;
		for (int i = 0; i < k; i++)
			sum += arr[i];

		ret[0] = sum;
		for (int j = 1, i = 0; j < ret.length; j++, i++) {
			ret[j] = ret[j - 1] - arr[i] + arr[i + k];
		}
		return ret;
	}

}
