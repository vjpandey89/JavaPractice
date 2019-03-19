package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem127 {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		int count = 0;
		char[] beginArr = new char[beginWord.length() - 1];
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);

		if (!wordList.contains(endWord))
			return 0;

		while (!queue.isEmpty()) {
			
			String newBeginString = queue.peek();
			queue.remove();
			beginArr = newBeginString.toCharArray();
			for (int i = 0; i < beginArr.length; i++) {
				beginArr = newBeginString.toCharArray();
				beginArr[i] = 'a' - 1;
				int dictcount = 0;
				for (int j = 0; j < 26; j++) {

					beginArr[i] = (char) (beginArr[i] + 1);
					String newBeginArrString = new String(beginArr);

					int index = checkInDict(newBeginArrString, wordList);
					if (newBeginArrString.equals(endWord))
						return count;

					if (index != -1) {
						wordList.remove(index);
						System.out.println(newBeginArrString);
						dictcount++;
						queue.add(newBeginArrString);
					}

				}
				count = count + dictcount;

			}
		}

		return 0;
	}

	public int checkInDict(String string, List<String> wordList) {
		int i;

		for (i = 0; i < wordList.size(); i++) {
			String dict = wordList.get(i);
			if (dict.equals(string)) {
				return i;
			}
		}

		return -1;

	}

	public static void main(String[] args) {

		Problem127 obj = new Problem127();
		List<String> wordList = new ArrayList<>();
		wordList.addAll(Arrays.asList("hot","dot","dog","lot","log","cog"));
		System.out.println(obj.ladderLength("hit", "cog", wordList));
	}

}

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. Note:
 * 
 * Return 0 if there is no such transformation sequence. All words have the same
 * length. All words contain only lowercase alphabetic characters. You may
 * assume no duplicates in the word list. You may assume beginWord and endWord
 * are non-empty and are not the same.
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog", return its length 5.
 * 
 * Input: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 */
