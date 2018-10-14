package leetcode;

public class Problem91 {
	
public int numDecodings(String s) {
        
        
		
	
	return numDecodingsUtil(s,s.length());
        
    }


int numDecodingsUtil(String s, int n){
	
	int count = 0;
	if(n==0||n==1 )
		return 1;
	if(s.charAt(n-1)>'0')
	count= numDecodingsUtil(s,n-1);

	if(s.charAt(n-2)=='1'||(s.charAt(n-2)=='2'&&s.charAt(n-1)<'7'))
		count=count+numDecodingsUtil(s,n-2);
	
	return count;
}


public static void main(String[] args) {
	Problem91 obj =new Problem91();
	System.out.println(obj.numDecodings("12321"));
	System.out.println(obj.numDecodingsDP("012321"));
	
	
}


private int numDecodingsDP(String s) {
	
	int memo[]=new int[s.length()+1];
	memo[0]=1;
	memo[1] = s.charAt(0) != '0' ? 1 : 0;
	for(int i=2;i<=s.length();i++){
		
		if(s.charAt(i-1)>'0')
			memo[i]=memo[i-1];
	
	if(s.charAt(i-2)=='1'||(s.charAt(i-2)=='2'&&s.charAt(i-1)<'7'))
		memo[i]=memo[i]+memo[i-2];
	}
	
	return memo[s.length()];
}

}
