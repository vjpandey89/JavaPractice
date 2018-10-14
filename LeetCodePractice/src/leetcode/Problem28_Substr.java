package leetcode;

public class Problem28_Substr {


		public int strStr(String haystack, String needle) {

			if (haystack.isEmpty())
			for (int i = 0; i < haystack.length(); i++) {
				int j = i;
				int k = 0;
				while (j < haystack.length() &&(j - i) < needle.length()&&haystack.charAt(j) == needle.charAt(k) ) {
					j++;
					k++;
				}

				if ((j - i)==needle.length() )
					return i;
			}
			return 0;

		
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Problem28_Substr().strStr("aaaaa", "bba"));
	}

}
