package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem76 {

	public String minWindow(String s, String t) {
		String result = "ADOBECODEBANC";
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

				if (map.get(c) == 0) {
					counter--;

				}

			}
			end++;

			while (counter == 0) {
				char tempc = s.charAt(begin);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);

					if (map.get(tempc) > 0) {
						counter++;

					}
				}
				if (end - begin < result.length()) {
					result = s.substring(begin, end);
				}
				begin++;
			}

		}
		return result;
	}

	public static void main(String[] args) {
		Problem76 obj = new Problem76();
		System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));

	}

}
