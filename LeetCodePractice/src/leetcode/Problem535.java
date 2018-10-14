package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem535 {
	
        private static final String BASE_HOST = "http://tinyurl.com/";
        private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        private Map<String, String> keyToUrl = new HashMap<>();
        private Map<String, String> urlToKey = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (urlToKey.containsKey(longUrl)) {
                return BASE_HOST + urlToKey.get(longUrl);
            }

            String key = null;
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    int r = (int)(Math.random() * SEED.length());
                    sb.append(SEED.charAt(r));
                }
                key = sb.toString();
            } while (keyToUrl.containsKey(key));

            keyToUrl.put(key, longUrl);
            urlToKey.put(longUrl, key);
            return BASE_HOST + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return keyToUrl.get(shortUrl.replace(BASE_HOST, ""));
        }
    
	public static void main(String[] args) {
		Problem535 obj=new Problem535();
		String str=obj.encode("https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/100268/Two-solutions-and-thoughts");
		System.out.println(str);
		str=obj.decode(str);
		System.out.println(str);
	}

}
