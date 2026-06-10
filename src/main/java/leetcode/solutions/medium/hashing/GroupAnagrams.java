package leetcode.solutions.medium.hashing;

import java.util.*;

/**
 * Pattern: Hashing
 * Time complexity: O(n * m), where n is the number of strings and m is the length of the longest string.
 * Space complexity: O(n)
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // e.g. {[1, 0, 1, 0, 0, 0, 0, ...] : [act, cat]}
        Map<String, List<String>> patternToStringsMap = new HashMap<>();

        for (String s : strs) {
            int[] pattern = new int[26];
            for (char c : s.toCharArray()) pattern[c - 'a']++;

            // We convert to String because arrays do not implement equals() and hashCode()
            // based on their contents. Using String ensures correct key comparison.
            String patternAsString = Arrays.toString(pattern);

            // computeIfAbsent avoids doing two lookups (putIfAbsent + get)
            // and creates the list lazily, making it more efficient and idiomatic.
            patternToStringsMap
                    .computeIfAbsent(patternAsString, k -> new ArrayList<>())
                    .add(s);
        }

        return new ArrayList<>(patternToStringsMap.values());
    }
}
