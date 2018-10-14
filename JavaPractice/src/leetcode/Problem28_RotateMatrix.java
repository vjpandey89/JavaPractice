package leetcode;

public class Problem28_RotateMatrix {
	
	
	public static void main(String[] args) {
		
		
		int[][] grid = new int[4][];
		grid[0] = new int[] { 1, 2, 3, 4 };
		grid[1] = new int[] { 5, 6, 7, 8 };
		grid[2] = new int[] { 9, 10, 11, 12 };
		grid[3] = new int[] { 13, 14, 15, 16 };
		
		rotateMatrix(grid);
	}

	private static void rotateMatrix(int[][] grid) {
		
		int n=grid.length;
		System.out.println(grid.length);
		
		 for (int i = 0; i < n / 2; i++)
	        {
	            // Consider elements in group of 4 in 
	            // current square
	            for (int j = i; j < n-i-1; j++)
	            {
				// store current cell in temp variable
                int temp = grid[i][j];
      
                // move values from right to top
                grid[i][j] = grid[j][n-1-i];
      
                // move values from bottom to right
                grid[j][n-1-i] = grid[n-1-i][n-1-j];
      
                // move values from left to bottom
                grid[n-1-i][n-1-j] = grid[n-1-j][i];
      
                // assign temp to left
                grid[n-1-j][i] = temp;
			}
		}

				
		 for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < n; j++)
					System.out.print(" " + grid[i][j]);
		
				System.out.print("\n");
			}
			System.out.print("\n");
	}
	
	
	

}
