package leetcode.solutions.medium.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Pattern: Sliding Window
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        Integer currMax = 0;
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            char curr = s.charAt(r);

            while (window.contains(curr)) {
                window.remove(s.charAt(l));
                l++;
            }

            window.add(curr);
            currMax = Math.max(currMax, window.size());
            r++;
        }
        return currMax;
    }
}
