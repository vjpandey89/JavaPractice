package arrays_string;

public class PattenMatchingBoyerMoore {

	public static void main(String[] args) {

		System.out.println(new PattenMatchingBoyerMoore().searchWithBadMatch("ABAAABCD", "ABC"));

	}

	private int searchWithBadMatch(String text, String pattern) {

		int textLength = text.length();
		int patLength = pattern.length();

		int badChar[] = new int[128];
		createBadCharArray(pattern, badChar);

		int s = 0;
		while (s <= (textLength - patLength)) {

			int j = patLength - 1;

			while (j >= 0 && pattern.charAt(j) == text.charAt(s + j))
				j--;
			if (j < 0) {
				return s;
			} else {
				s = s + Math.max(1, j - badChar[text.charAt(s + j)]);
			}

		}

		return -1;
	}

	private void createBadCharArray(String pattern, int[] badChar) {

		for (int i = 0; i < 128; i++) {
			badChar[i] = -1;
		}
		for (int i = 0; i < pattern.length(); i++) {
			badChar[pattern.charAt(i)] = i;
		}

	}

}
