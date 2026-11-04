package leetcode.solutions.medium.slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Pattern: Sliding Window
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int currMax = 0;
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            // Always add to the window first, then check if it needs shrinking.
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);

            while (((r - l + 1) - Collections.max(window.values())) > k) {
                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                l++;
            }
            
            currMax = Math.max(currMax, r - l + 1);
            r++;
        }
        return currMax;
    }
}