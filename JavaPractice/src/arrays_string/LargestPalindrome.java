package arrays_string;

public class LargestPalindrome {

	public static void main(String[] args) {
		
		finrLongestPalindromeBruteForce("nitinnnss");
		finrLongestPalindromeDP("nitinnnss");
		finrLongestPalindromeRecursion("nitinnnss");
	}

	
	
	
	private static void finrLongestPalindromeRecursion(String string) {
		
		
	}




	private static void finrLongestPalindromeDP(String string) {
		
	char []str=string.toCharArray();
	int LP[][]=new int[str.length][str.length];
	for(int i=0;i<str.length;i++){
		LP[i][i] = 1;			
	}
	
	for(int k=2;k<str.length;k++)
	{
		for(int i=0;i<str.length-k;i++)
		{
			if((str[i]==str[k-1])&&k==2)
			{
				LP[i][k-1]=2;
			}
			else if(str[i]==str[k-1])
			{
				//LP[i][k-1]=L[i][k-1]+1;
			}
		}
		
		
	}

	}

	private static void finrLongestPalindromeBruteForce(String string) {
		
		
		char [] str=string.toCharArray();
		int palindromelength=0;
		char []palindrome=new char[string.length()];
		
		for(int i=0;i<str.length;i++)
		{
			for(int j=i;j<str.length;j++)
			{
				if(isPalindrome(string.substring(i,j)))
				{
					if((j-i+1)>palindromelength){
				//		System.out.println("\n Substring "+string.substring(i,j));
						palindrome=string.substring(i,j).toCharArray();
						palindromelength=j-i+1;
					}
					
				}
				
			}
		}
		
		System.out.println("Final result is ");
		for(char ch:palindrome)
			System.out.print(ch);
		
	}




	private static void printAllSubstrings(String str) {

		char[] chars = str.toCharArray();
		int length = str.length();
		StringBuilder substring=new StringBuilder();

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				
				for (int k = i; k <=j; k++){
					substring.append(str.charAt(k));
				}
			System.out.println(substring);	
			substring=new StringBuilder();
			}
		}

	}

	public static String largestPalindrome(String str) {
		char[] chars = str.toCharArray();
		int length = str.length();

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {

			}
		}

		return str;

	}

	public static boolean isPalindrome(String str) {
		for (int i = 0, j = str.length() - 1; i < str.length() - 1; i++, j--)
			if (str.charAt(i) != str.charAt(j))
				return false;
		return true;

	}
}
