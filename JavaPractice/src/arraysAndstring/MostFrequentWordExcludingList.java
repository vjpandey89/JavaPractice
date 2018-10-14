package arraysAndstring;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostFrequentWordExcludingList {
	
	
	
	public static void main(String[] args) {
		String stringArray="jack and jill went to the market to buy bread and cheese.cheese is jack and jill's favorite food";
		String []banned={"and","he","the","to","is","jack","jill"};
		List<String> candidates=mostCommonWord(stringArray,banned);
		
		for(String str:candidates)
			System.out.print(str+" ");
		
	}
	
	public static List<String> mostCommonWord(String p, String[] banned) {
		List<String> result = new LinkedList<>();
		Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String[] words = p.replaceAll("\\pP" , " ").toLowerCase().split("[^A-Za-z]");
        for (String w : words) if (!ban.contains(w)) map.put(w, map.getOrDefault(w, 0) + 1);
     
        int maxValue= Collections.max(map.values());
        for (Map.Entry<String, Integer> entry : map.entrySet())        
           if(entry.getValue()==maxValue)
        	   result.add(entry.getKey());      
       return result;
       
       
        
    }
	

}
