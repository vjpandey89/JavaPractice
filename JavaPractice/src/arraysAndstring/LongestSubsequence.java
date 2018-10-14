package arraysAndstring;

public class LongestSubsequence {
	public static void main(String[] args) {
		LCS("vijay", "pandey");
	}

	private static void LCS(String str1, String str2) {

		int l1 = str1.length();
		int l2 = str2.length();
		char strarr1[] = str1.toCharArray();
		char strarr2[] = str2.toCharArray();

		int[][] lcs = new int[l1 + 1][l2 + 1];

		for (int i = 0; i <= l1; i++)
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0)
					lcs[i][j] = 0;
				else if (strarr1[i - 1] == strarr2[j - 1])
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				else
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);

			}

		for (int[] arr : lcs) {
			System.out.println();
			for (int i : arr)
				System.out.print(i + "\t");
		}

		int i = l1;
		int j = l2;
		int index = 0;
		char[] result = new char[Math.min(l1, l2)];
		while (i > 0 && j > 0) {

			if (strarr1[i - 1] == strarr2[j - 1]) {

				result[index] = strarr1[i - 1];
				index++;
				i = i - 1;
				j = j - 1;
			} else if (lcs[i - 1][j] > lcs[i][j - 1]) {
				i = i - 1;
			} else
				j = j - 1;
		}

		for (char ch : result)
			System.out.print(ch);

	}

}
