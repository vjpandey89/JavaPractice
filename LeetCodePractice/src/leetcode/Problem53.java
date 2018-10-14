package leetcode;

class Problem53 {
	public int maxSubArray(int[] nums) {

		return maxSubArray(nums, 0, nums.length - 1);
	}

	public int maxSubArray(int[] nums, int left, int right) {
		if (left == right)
			return nums[left];

		int med = (left + right) / 2;

		return Math.max(Math.max(maxSubArray(nums, left, med), maxSubArray(nums, med + 1, right)),
				crossSum(nums, left, med, right));

	}

	public int crossSum(int nums[], int left, int med, int right) {

		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = med; i >= left; i--) {
			sum = sum + nums[i];
			if (leftSum < sum)
				leftSum = sum;
		}

		sum = 0;
		for (int j = med + 1; j <= right; j++) {

			sum = sum + nums[j];
			if (rightSum < sum)
				rightSum = sum;
		}

		return leftSum + rightSum;
	}

	public static void main(String[] args) {
		System.out.println(new Problem53().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

}
