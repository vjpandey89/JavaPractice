/*package dynamicprogramming;

import java.util.HashMap;

public class RobotPath {

	static int count;

	public static void main(String[] args) {
		
		 * int[][] obstacleGrid = { { 0, 1, 0 }, { 1, 1, 0 }, { 0, 0, 0 } };
		 

		int[][] obstacleGrid = { { 0 } };
		
		
		
		
		boolean [][]memo=new boolean[][];
		System.out.println(" row and col is "+(obstacleGrid.length - 1)+" "+(obstacleGrid[0].length - 1));

		boolean result = uniquePathsWithObstaclesHelper(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);

		

	}

	private static boolean uniquePathsWithObstaclesHelper(int[][] obstacleGrid, int row, int col) {

		if(obstacleGrid[row][col])
		
		if (row == 0 && col == 0) {
			count++;
			return true;
		}

		if (row < 0 || col < 0 || )
			return false;

		uniquePathsWithObstaclesHelper(obstacleGrid, row - 1, col); 
				uniquePathsWithObstaclesHelper(obstacleGrid, row, col - 1);
		return false;

	}

}*/