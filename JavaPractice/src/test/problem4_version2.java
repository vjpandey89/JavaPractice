package test;

public class problem4_version2 {

	public static void main(String[] args) {
		System.out.println(findLargestPalindrome());
	}

	public static long findLargestPalindrome() {

		int a = 999, b, db, largest = 0;
		while (a >= 100) {
			if (a % 11 == 0) {

				b = a;
				db = 1;
			} else {
				b = a - (a % 11);
				db = 11;

			}

			while (b <= a) {

				if (a * b < largest)
					break;
				if (isPalindrome(a * b))
					largest = a * b;
				b = b - db;
			}
			a = a - 1;
		}
		return largest;

	}

	/*
	 * determines whether or not an integer is a palindrome; that is, if it
	 * reads the same from both ways
	 */
	public static boolean isPalindrome(long n) {
		String s = String.valueOf(n);
		StringBuilder reverseString = new StringBuilder();

		// reverse the string
		for (int i = s.length() - 1; i > -1; i--) {
			reverseString.append(s.charAt(i));
		}

		return reverseString.toString().equals(s);
	}

	/*
	 * using the reverse() method in the StringBuilder class instead of
	 * reversing the string through iterations
	 */
	public static boolean isPalindrome2(long n) {
		String s = String.valueOf(n);
		return new StringBuilder(s).reverse().toString().equals(s);
	}

	public static boolean isPalindrome3(long n) {

		return false;

	}
}
