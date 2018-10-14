package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {

	public List<List<Integer>> threeSum(int[] nums) {
		
List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(nums.length<3)
            return result;
        
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-2; i++) {

			int l = i + 1;
			int r = nums.length - 1;
        if(i==0||nums[i]!=nums[i-1])
			while (l < r) {
				if ((nums[i] + nums[l] + nums[r]) == 0) {
					
					result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[l], nums[r])));
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
					l++;
					r--;
				} else if ((nums[i] + nums[l] + nums[r]) < 0)
					l++;
				else
					r--;

			}

		}

		return result;
	}

	public static void main(String[] args) {

		Problem15 obj = new Problem15();
		int arr[] = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = obj.threeSum(arr);

		for (List<Integer> list : result) {
			System.out.println();
			for (int i : list)
				System.out.print(" " + i);

		}
	}

}
