package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem438 {

	public List<Integer> findAnagrams(String s, String t) {
		List<Integer> result = new LinkedList<>();
		if (t.length() > s.length())
			return result;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int counter = map.size();

		int begin = 0, end = 0;
		int head = 0;
		int len = Integer.MAX_VALUE;

		while (end < s.length()) {
			char c = s.charAt(end);

			if (map.containsKey(c)) {
				
				map.put(c, map.get(c) - 1);
				System.out.println("\n 1st a : "+map.get('a')+" b :"+map.get('b')+" c : "+map.get('c')+" counter : "+counter);
				if (map.get(c) == 0)
				{
					counter--;
					System.out.println("\n 2nd na : "+map.get('a')+" b :"+map.get('b')+" c : "+map.get('c')+" counter : "+counter);
				}

			}
			end++;

			while (counter == 0) {
				char tempc = s.charAt(begin);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					System.out.println("\n3rd a : "+map.get('a')+" b :"+map.get('b')+" c : "+map.get('c')+" counter : "+counter);
					if (map.get(tempc) > 0) {
						counter++;
						System.out.println("\n4rth a : "+map.get('a')+" b :"+map.get('b')+" c : "+map.get('c')+" counter : "+counter);
					}
				}
				if (end - begin == t.length()) {
					result.add(begin);
				}
				begin++;
			}

		}
		return result;
	}

	public static void main(String[] args) {
		Problem438 obj = new Problem438();
		List<Integer> list = obj.findAnagrams("cbaebabacd", "abc");
		for (int i : list)
			System.out.println(" " + i);
	}

}
