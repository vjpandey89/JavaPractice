package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Problem127_2{

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		int count = 0;
		char[] beginArr = new char[beginWord.length() - 1];
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);

		if (!wordList.contains(endWord))
			return 0;

		while (!queue.isEmpty()) {
			count++;
			String newBeginString = queue.peek();
			queue.remove();
			beginArr = newBeginString.toCharArray();
			for (int i = 0; i < beginArr.length; i++) {
				beginArr = newBeginString.toCharArray();
				beginArr[i] = 'a' - 1;
				for (int j = 0; j < 26; j++) {

					beginArr[i] = (char) (beginArr[i] + 1);
					String newBeginArrString = new String(beginArr);

					int index = checkInDict(newBeginArrString, wordList);
					if (newBeginArrString.equals(endWord))
						return count;

					if (index != -1) {
						wordList.remove(index);
						System.out.println(newBeginArrString);
						count++;
						queue = null;
						queue = new LinkedList<>();
						queue.add(newBeginArrString);
						i = 27;
						break;
					} else {

						queue.add(newBeginArrString);
					}

				}

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

		Problem127_2 obj = new Problem127_2();
		List<String> wordList = new ArrayList<>();
		wordList.addAll(Arrays.asList("poon", "plee", "same", "poie", "plie", "poin", "plea"));
		System.out.println(obj.ladderLength("toon", "plea", wordList));
	}

}
