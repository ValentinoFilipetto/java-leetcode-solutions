package leetcode.solutions.easy;

/**
 * Pattern: Hashing
 * Time complexity: O(m + n), where m is the length of s and n is the length of t.
 * Space complexity: O(1) since we have at most 26 different characters.
 * */

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] occurrences = new int[26];
        for (int i = 0; i < s.length(); i++) {
            occurrences[s.charAt(i) - 'a']++;
            occurrences[t.charAt(i) - 'a']--;
        }

        for (int val : occurrences) {
            if (val != 0) return false;
        }
        return true;
    }
}
