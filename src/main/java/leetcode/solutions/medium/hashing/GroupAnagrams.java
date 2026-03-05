package leetcode.solutions.medium.hashing;

import java.util.*;

/**
 * Pattern: Hashing
 * Time complexity: O(n * m), where n is the number of strings and m is the length of the longest string.
 * Space complexity: O(n)
 * */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // We use List<String> instead of, say, String[] because we need flexible size.
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            int[] pattern = new int[26];
            for (char c : s.toCharArray()) {
                pattern[c - 'a']++;
            }
            // We convert our pattern to String because, even though we could hash int[] too,
            // String is more appropriate as key in a hash map.
            String key = Arrays.toString(pattern);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
