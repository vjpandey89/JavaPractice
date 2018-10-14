package leetcode;

public class Problem14 {
	

	    public String longestCommonPrefix(String[] strs) {
	        
	        return getLongestPrefix(strs,0,strs.length-1);
	        
	    }
	    
	    
	    String getLongestPrefix(String[] strs,int left,int right) {
	        
	        if(left==right)
	            return strs[left];
	        int med=(left+right)/2;
	        String left_prefix=getLongestPrefix(strs,left,med);
	        String rightPrefix=getLongestPrefix(strs,med+1,right);
	        
	        while (rightPrefix.indexOf(left_prefix) != 0) {
	            left_prefix = left_prefix.substring(0, left_prefix.length() - 1);
	            if (left_prefix.isEmpty()) return "";
	        }
	        
	        return left_prefix;
	        
	    }
	    
	    
	    public static void main(String[] args) {
			System.out.println(new Problem14().longestCommonPrefix(new String[]{"flower","flow","flight"}));
		}
	

}
