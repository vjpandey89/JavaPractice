package leetcode;

import java.util.Arrays;

public class Problem1 {

	public static void main(String[] args) {
		Problem1 obj = new Problem1();
		int arr[] = { 2, 7, 11, 15 };

		int[] result = obj.twoSum(arr, 9);
		if (result != null)
			System.out.println(arr[0] + " " + arr[1]);
	}

	private int[] twoSum(int[] arr, int sum) {

		if (arr.length < 2)
			return null;
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			if (arr[low] + arr[high] == sum)
				return new int[] { arr[low], arr[high] };
			else if (arr[low] + arr[high] < sum)
				low++;
			else
				high--;
		}
		
		return null;

	}

}
