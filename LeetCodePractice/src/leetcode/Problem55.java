package leetcode;

public class Problem55 {

	public static void main(String[] args) {
		System.out.println(jumper(new int[] { 2, 4, 2, 1, 0, 2, 0 }));
	}

	private static boolean jumper(int[] nums) {
		// TODO Auto-generated method stub
		// return jumperhelper(nums, 0);
		
		
		boolean[] memo = new boolean[nums.length];

		for (int i = 0; i < memo.length; i++)
			memo[i] = true;

		return jumperhelper2(nums, 0, memo);
	}

	static boolean jumperhelper(int[] nums, int pos) {

		System.out.println("Pos is : " + pos);

		if (pos == nums.length - 1)
			return true;

		for (int i = 0; i < nums[pos] && i < nums.length - pos; i++) {

			if (jumperhelper(nums, pos + i + 1))
				return true;

		}

		return false;
	}

	static boolean jumperhelper2(int[] nums, int pos, boolean[] memo) {

		System.out.println("Pos is : " + pos);

		if (pos == nums.length - 1)
			return true;

		if (!memo[pos])
			return false;
		else
			for (int i = nums[pos]; i > 0; i--) {

				if (pos + i < nums.length && jumperhelper2(nums, pos + i, memo)) {
					System.out.println(" true with pos " + pos);
					return true;

				} else
					System.out.println(" false 2 with pos " + pos);

			}

		memo[pos] = false;
		System.out.println(" false 1 with pos " + pos);
		return false;
	}

}
