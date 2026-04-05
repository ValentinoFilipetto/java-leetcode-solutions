package leetcode.solutions.medium.slidingwindow;

import java.util.Arrays;

/**
 * Pattern: Sliding Window
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Note: we might be tempted to use a HashSet to check for the presence of characters, 
 * but since we need to check for the frequency of characters, using an array to count the frequency is more efficient
 * and less error-prone than using a HashMap or HashSet.
 */

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] need = new int[26];
        int[] window = new int[26];
        
        // Count the frequency of characters in s1.
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;
            
            // If the window size exceeds the length of s1, shrink the window from the left.
            if (right - left + 1 > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }
            
            // Check if the current window matches the frequency of characters needed.
            if (Arrays.equals(need, window)) {
                return true;
            }
        }
        return false;
    }
}