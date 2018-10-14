package arraysAndstring;

public class MatrixRotation {

	
	
	
	public static void main (String[] args) 
    {
        int N = 4;
         
        // Test Case 1
        int mat[][] =
        {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
      
      
        // Tese Case 2
        /* int mat[][] = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };
         */
      
        // Tese Case 3
        /*int mat[][] = {
                        {1, 2},
                        {4, 5}
                    };*/
      
        // displayMatrix(mat);
      
        rotateMatrix(N,mat);
      
        // Print rotated matrix
        displayMatrix(N,mat);
    }

	static void displayMatrix(int N, int mat[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);
      
            System.out.print("\n");
        }
        System.out.print("\n");
    }

	private static void rotateMatrix(int n, int[][] mat) {
		
		for(int i=0;i<n/2;i++)
		{
			for(int j=i;j<n-i-1;j++)
			{
				int temp=mat[i][j];
				
				mat[i][j]=mat[n-1-j][i];
				
				mat[n-1-j][i]=mat[n-1-i][n-1-j];
				
				mat[n-1-i][n-1-j]=mat[j][n-1-i];
				
				mat[j][n-1-i]=temp;
				
			}
		}
		
	}
	
}
