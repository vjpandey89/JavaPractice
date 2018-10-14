package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem118 {

	private List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
		int i,j;
		if (numRows == 0) {
            return result;
        }

		"".indexOf("");
		
        // Second base case; first row is always [1].
		result.add(new ArrayList<>());
		result.get(0).add(1);
        
        
		for ( i = 1; i < numRows; i++) {
			List<Integer> list = new ArrayList<Integer>(i + 2);

			list.add(0,1);
			for ( j = 1; j < i; j++) {
				list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
			}
			
			
			list.add(i,1);
			result.add(list);

		}

		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = new Problem118().generate(5);
		
		for(List<Integer> list:result){System.out.println();
			for(int n:list){
				System.out.print(" "+n);
			}
				
		}
	}

}
