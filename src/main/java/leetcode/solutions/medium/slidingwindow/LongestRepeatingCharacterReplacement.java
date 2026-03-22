package leetcode.solutions.medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Pattern: Sliding Window
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int l = 0, maxFrequency = 0, maxLength = 0;

        for (int r = 0; r < s.length(); r++) {
            // Update the count of the current character and the maximum frequency in the current window
            count.put(s.charAt(r), 1 + count.getOrDefault(s.charAt(r), 0));
            maxFrequency = Math.max(maxFrequency, count.get(s.charAt(r)));
            
            // If the current window size minus the count of the most frequent character is greater than k,
            // it means we need to shrink the window from the left
            while (((r - l + 1) - maxFrequency) > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            maxLength = Math.max(maxLength, (r - l + 1));
        }
        return maxLength;
    }
}