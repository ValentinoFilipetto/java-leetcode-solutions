package leetcode.solutions.easy;

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
