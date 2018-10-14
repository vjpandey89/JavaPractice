package corejava.basics.arrays;

public class PascalUsingArrays {
	
	public static void main(String[] args) {
		
		
		int n=10;
		int[][] pascal=new int[n][];
		for(int i=0;i<n;i++)
		{
			pascal[i]=new int[i+1];
			int j;
			pascal[i][0]=1;
			for(j=1;j<i;j++)
			{
				pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
			}
			pascal[i][i]=1;
		}
		
		for (int i=0;i<pascal.length;i++) {
			System.out.print("\n");
			for (int j=0;j<n-pascal[i].length;j++)System.out.print(" ");
			for (int j=0;j<pascal[i].length;j++) {
				System.out.print(pascal[i][j]+" ");
			}
		}		
	}

}
