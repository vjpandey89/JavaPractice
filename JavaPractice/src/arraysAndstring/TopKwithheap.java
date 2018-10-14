package arraysAndstring;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKwithheap {
	
	
	
	public static void main(String[] args) {
		String []stringArray={"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		List<String> candidates=topKFrequent(stringArray,3);
		
		for(String str:candidates)
			System.out.print(str+" ");
		
	}
	
	    public static List<String> topKFrequent(String[] words, int k) {
	        
	        List<String> result = new LinkedList<>();
	        Map<String, Integer> map = new HashMap<>();
	        for(int i=0; i<words.length; i++)
	        {
	            if(map.containsKey(words[i]))
	                map.put(words[i], map.get(words[i])+1);
	            else
	                map.put(words[i], 1);
	        }
	        
	        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
	                 (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
	        );
	        System.out.println("Constructor");
	        Iterator itr = pq.iterator();
	        while (itr.hasNext())
	            System.out.println(itr.next());
	        
	        
	        for(Map.Entry<String, Integer> entry: map.entrySet())
	        {
	            pq.offer(entry);
	             itr = pq.iterator();
	             System.out.println("Before");
		        while (itr.hasNext())
		            System.out.println(itr.next());
	            if(pq.size()>k)
	                pq.poll();
	             itr = pq.iterator();
	             System.out.println("After");
		        while (itr.hasNext())
		            System.out.println(itr.next());
	        }

	        while(!pq.isEmpty())
	            result.add(0, pq.poll().getKey());
	        
	        return result;
	    }
	

}
