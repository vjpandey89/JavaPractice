package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem49 {
	public static List<List<String>> groupAnagrams(String[] strs) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103 };

		List<List<String>> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (String s : strs) {
			int key = 1;
			for (char c : s.toCharArray()) {
				key *= prime[c - 'a'];
			}
			List<String> t;
			if (map.containsKey(key)) {
				t = res.get(map.get(key));
			} else {
				t = new ArrayList<>();
				res.add(t);
				map.put(key, res.size() - 1);
			}
			t.add(s);
		}
		return res;
	}
	
	
	public static void main(String[] args)
    {
 
        String word[] = { "eat", "pots", "onset", "stone", "rail", "risen", "caret", "resin", "react", "siren", "sitar", "stair", "liar", "stop", "trace", "notes", "tea", "lair" };
 
        List<List<String>>  res= groupAnagrams(word);
        
        
        for(List<String> list :res )
        {
        	System.out.println();
        	
        	for(String ch:list)
        	{
        		System.out.print(" "+ch);
        	}
        }
        
    }

}
