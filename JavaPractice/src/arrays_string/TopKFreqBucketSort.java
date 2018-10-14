package arrays_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFreqBucketSort {
	
	
	
	    public List<String> topKFrequent(String[] words, int k) {
	        if (words == null || words.length == 0) {
	            return new ArrayList<String>();
	        }

	        Map<String, Integer> map = new HashMap();
	        for (String s: words) {
	            map.put(s, map.getOrDefault(s, 0) + 1);
	        }

	        List<String>[] bucket = new List[words.length + 1];
	        for (Map.Entry<String, Integer> set : map.entrySet()) {
	            int frequecny = set.getValue();
	            if (bucket[frequecny] == null) {
	                bucket[frequecny] = new ArrayList<>();
	            }
	            bucket[frequecny].add(set.getKey());
	        }

	        List<String> rst = new ArrayList<>();
	        for (int i = bucket.length - 1; i >= 0; i--) {
	            if (bucket[i] != null) {
	                // Sort the string to meeting demand.
	                Collections.sort(bucket[i]);
	                // We can use addAll method to avoid adding too much elements (exceeding k).
	                for (int j = 0; j < bucket[i].size() && rst.size() < k; j++) {
	                    rst.add(bucket[i].get(j));
	                }
	            }
	        }
	        return rst;
	    
	}

}
