package leetcode.solutions.medium.slidingwindow;

import java.util.Arrays;

/**
 * Pattern: Sliding Window
 * Time complexity: O(n)
 * Time complexity is not O(n * m) because the array comparison inside the loop
 * happens in constant O(26) time.
 * Space complexity: O(1)
 */

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int l = 0;
        int r = 0;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (char c : s1.toCharArray()) s1Count[c - 'a']++;

        while (r < s2.length()) {
            // If size of window exceeds s1.length(), shrink it from the left.
            // Checking on r + 1 means that we check at each iteration after the first window.
            if (r + 1 > s1.length()) {
                s2Count[s2.charAt(l) - 'a']--;
                l++;
            }
            s2Count[s2.charAt(r) - 'a']++;
            if (Arrays.equals(s1Count, s2Count)) return true;
            r++;
        }
        return false;
    }
}