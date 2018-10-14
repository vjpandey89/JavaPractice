package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Problem380 {

	
	 Map<Integer,Integer> map;
	    int list[];
	    private static final int DEFAULT_CAPACITY = 100;
	    int top=-1;
	    
	    /** Initialize your data structure here. */
	    public Problem380() {
	        map=new HashMap<Integer,Integer>();
	        list=new int[DEFAULT_CAPACITY];
	        
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        
	        if(!map.containsKey(val))
	        {
	            if(top==DEFAULT_CAPACITY-1)
	               list=createNewAndShiftArray(list); 
	            ++top;
	             list[top]=val;
	            
	             map.put(val,top);
	            return true;
	        }
	        return false;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        
	        if(map.containsKey(val)){
	            
	        	
	        	
	            int indexToDelete=map.get(val);
	            int lastNumber=list[top];   
	            if(top!=indexToDelete)
	            {
	            	list[indexToDelete]=lastNumber;
	            	map.put(lastNumber,indexToDelete);
	            }
	            else 
	            	list[indexToDelete]=0;
	            top=top<0?0:top--;
	            map.remove(val);
	            
	            
	            return true;
	        }
	        return false;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        
	    	return list[new Random().nextInt(top+1)];
	        
	    }
	    
	    
	    int[] createNewAndShiftArray(int arr[])
	    {
	        int []newArr=new int[arr.length+DEFAULT_CAPACITY];
	        
	        for(int i=0;i<arr.length;i++)
	            newArr[i]=arr[i];
	        
	        arr=null;
	        return newArr;
	    } 
    
    
    public static void main(String[] args) {
    	
    	Problem380 obj = new Problem380();
    	
    	System.out.println(obj.insert(0));
    	System.out.println(obj.insert(1));
    	System.out.println(obj.remove(0));
    	System.out.println(obj.insert(2));
    	System.out.println(obj.remove(1));
    	System.out.println(obj.getRandom());
    	
    	
	}
    
    
}

