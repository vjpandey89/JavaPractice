package leetcode;

public class Problem125 {
	

    public boolean isPalindrome(String s) {
        
        int i=0;
        int j=s.length()-1;
        
        while(i<j){
            if(!checkAlphaNumeric(s.charAt(i)))
            {
                i++;
                continue;
            }
            if(!checkAlphaNumeric(s.charAt(j)))
            {
                j--;
                continue;
            }
            if(Character.toUpperCase(s.charAt(i))==Character.toUpperCase(s.charAt(j)))
            {
                i++;
                j--;
            }
            else
                return false;
        }
    
        return i>=j;
        
    }
    
   static boolean  checkAlphaNumeric(char c)
    {
        if((c>='A'&&c<='Z')||(c>='a'&&c<='z')||(c>='0'&&c<='9'))
            return true;
       return false;
    }
   
   public static void main(String[] args) {
	
	   Problem125 obj=new Problem125();
	   
	   System.out.println(obj.isPalindrome("aa"));
}

}
