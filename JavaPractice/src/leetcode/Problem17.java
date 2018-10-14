package leetcode;



public class Problem17 {
public static void main(String[] args) {
	phoneDigits(23);
	
	cartiesienProductOf2String("abc","def");
}

private static void cartiesienProductOf2String(String string, String string2) {
	
	
	for(int i=0;i<string.length();i++)
		for(int j=0;j<string2.length();j++)
			System.out.println(string.charAt(i)+" "+string2.charAt(j));
	
}

private static void phoneDigits(int n)
{
	
}

}
