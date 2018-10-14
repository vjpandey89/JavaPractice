package arraysAndstring;

import java.util.ArrayList;

public class StringPermutation {

	public static void main(String[] args) {
		/*
		 * ArrayList<String> permutations=permute("abc");
		 * 
		 * for(String str:permutations) System.out.println(" "+str);
		 */

		ArrayList<String> permutations2 = permute2("abc");

		for (String str : permutations2)
			System.out.println(" " + str);

	}

	private static ArrayList<String> permute(String string) {
		ArrayList<String> permutations = new ArrayList<>();

		if (string.length() == 0) {
			permutations.add("");
			return permutations;

		}

		char first = string.charAt(0);
		String remainder = string.substring(1);

		ArrayList<String> words = permute(remainder);

		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				String s = insertCharAt(word, first, i);
				permutations.add(s);
			}
		}

		return permutations;

	}

	private static ArrayList<String> permute2(String remainder) {

		int len = remainder.length();
		ArrayList<String> permutations = new ArrayList<>();

		if (len == 0) {
			permutations.add("");
			return permutations;
		}

		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			ArrayList<String> partial = permute2(before + after);

			for (String str : partial)
				permutations.add(remainder.charAt(i) + str);
		}

		return permutations;

	}

	static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;

	}

}
